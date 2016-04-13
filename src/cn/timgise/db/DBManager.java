package cn.timgise.db;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author osc 红薯
 * Created by Timgise 2016年3月22日
 */
public class DBManager {
	
	private static final Log LOG=Logs.getLog(DBManager.class);
	private static final ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
	private static Boolean show_sql = false;
	private static DruidDataSource dataSource;
	
	private DBManager(){}
	
	static {
		LOG.debug("####################DBManger Class Loaded, Execute Once ! ###################");
		initDataSource(null);
	}
	
	/**
     * 初始化连接池
     * @param props
     * @param show_sql
     */
    private final static void initDataSource(Properties dbProperties) {
    	try {
            if(dbProperties == null){
            	
            	LOG.debug("args is null+++++++++");
            	
                dbProperties = new Properties();
                dbProperties.load(DBManager.class.getResourceAsStream("/db/jdbc.properties"));
            }
            Properties cp_props = new Properties();
            for(Object key : dbProperties.keySet()) {
                String skey = (String)key;
                if(skey.startsWith("jdbc.")){
                    String name = skey.substring(5);
                    cp_props.put(name, dbProperties.getProperty(skey));
                    if("show_sql".equalsIgnoreCase(name)){
                        show_sql = "true".equalsIgnoreCase(dbProperties.getProperty(skey));
                    }
                }
            }
            dataSource = (DruidDataSource)Class.forName(cp_props.getProperty("datasource")).newInstance();
            
//            if(dataSource.getClass().getName().indexOf("c3p0")>0){
//                //Disable JMX in C3P0
//                System.setProperty("com.mchange.v2.c3p0.management.ManagementCoordinator", 
//                        "com.mchange.v2.c3p0.management.NullManagementCoordinator");
//            }
            LOG.info("Using DataSource : " + dataSource.getClass().getName());
            //有没有好的方式？
            dataSource.setUrl(cp_props.getProperty("jdbcUrl"));
			dataSource.setDriverClassName(cp_props.getProperty("driverClass"));
			dataSource.setUsername(cp_props.getProperty("user"));
			dataSource.setPassword(cp_props.getProperty("password"));
			dataSource.setMaxActive(Integer.valueOf(cp_props.getProperty("maxActive")));
			dataSource.setFilters(cp_props.getProperty("filters"));
			dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(cp_props
					.getProperty("minEvictableIdleTimeMillis")));
			dataSource.setDefaultAutoCommit(Boolean.valueOf(cp_props
					.getProperty("defaultAutoCommit")));
			dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(cp_props.getProperty("timeBetweenEvictionRunsMillis")));
           //--===========================================================================
			Connection conn = getConnection();
            DatabaseMetaData mdm = conn.getMetaData();
            LOG.info("Connected to " + mdm.getDatabaseProductName() + 
                              " " + mdm.getDatabaseProductVersion());
            closeConnection();
        } catch (Exception e) {
        	e.printStackTrace();
            //throw new DBException(e);
        }
    }
	
	//获取数据库连接
	private static final Connection getConnection() throws SQLException{
		Connection conn = conns.get();
		
		if(conn ==null || conn.isClosed()){
            conn = dataSource.getConnection();
            conns.set(conn);
        }
		
		return (show_sql && !Proxy.isProxyClass(conn.getClass()))?
                new _DebugConnection(conn).getConnection():conn;
	}
	//关闭数据库连接
	private static final void closeConnection(){
		Connection conn = conns.get();
		
		try {
			if (conn !=null && !conn.isClosed()) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			LOG.error("Unable to close connection !!!",e);
			e.printStackTrace();
		}
		conns.set(null);
	}
	
	/**
     * 用于跟踪执行的SQL语句
     * @author osc 红薯
     */
    static class _DebugConnection implements InvocationHandler {
         
        private final static Log log = Logs.getLog(_DebugConnection.class);
         
        private Connection conn = null;
 
        public _DebugConnection(Connection conn) {
            this.conn = conn;
        }
 
        /**
         * Returns the conn.
         * @return Connection
         */
        public Connection getConnection() {
            return (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
                             conn.getClass().getInterfaces(), this);
        }
         
        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            try {
                String method = m.getName();
                if("prepareStatement".equals(method) || "createStatement".equals(method))
                    log.info("[SQL] >>> " + args[0]);              
                return m.invoke(conn, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
 
    }
	
}
