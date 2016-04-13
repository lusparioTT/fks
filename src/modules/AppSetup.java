package modules;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import modules.domain.Sys_User;
import modules.service.RedisService;
import net.sf.ehcache.CacheManager;

import org.apache.velocity.app.Velocity;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.lang.Stopwatch;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.plugins.cache.dao.CachedNutDaoExecutor;
import org.nutz.plugins.quartz.NutQuartzCronJobFactory;

import cn.timgise.db.DBManager;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Nutz内核启动完成后初始化操作
 * 
 */
public class AppSetup implements Setup {
	Log log = Logs.getLog(AppSetup.class);

	public void init(NutConfig config) {

		log.debugf("WebApplication Root：%s" + config.getAppRoot());
		Ioc ioc=config.getIoc();
		//DBManager check
		
		
		
		// 检查一下Ehcache CacheManager 是否正常.
		CacheManager cacheManager = ioc.get(CacheManager.class);
		log.debug("Ehcache CacheManager = " + cacheManager);
		CachedNutDaoExecutor.DEBUG = true;
		
		
		//----------------------------------------------------------------------
		// redis测试
		JedisPool jedisPool = ioc.get(JedisPool.class);
		try (Jedis jedis = jedisPool.getResource()) { // Java7的语法
				
		} finally {
		}
		RedisService redis = ioc.get(RedisService.class);
		if(redis==null) log.warn("redis service [redis] is null !!!");
		
		// 初始化系统数据
		initSysInfo(config);
		// velocity初始化
		initVelocity(config);
		
		//quartz 
		//ioc.get(NutQuartzCronJobFactory.class);
		
	}

	public void destroy(NutConfig config) {
		
		log.info("");
		
		Ioc ioc=config.getIoc();
		//当应用停止时
		if (ioc.get(JedisPool.class) !=null) {
			ioc.get(JedisPool.class).close();
		}
		
		// Mvcs.getReq().getSession().invalidate();
	}
	
	private void initSysInfo(NutConfig config) {
		Ioc ioc = config.getIoc();
		Dao dao = ioc.get(Dao.class);
		
		//毫秒计时
		Stopwatch stopwatch = Stopwatch.begin();
		dao.create(Sys_User.class, false);

		stopwatch.stop();
		log.debug("系统数据初始化耗时：" + stopwatch.getDuration());
	}

	private void initVelocity(NutConfig nc) {
		log.info("Velocity Init Start...");
		try {
			InputStream ins = getClass().getClassLoader().getResourceAsStream(
					"velocity.properties");
			Properties props = new Properties();

			props.load(ins);
			ins.close();
			// 单例模式
			// Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM, this);

			Velocity.setApplicationAttribute("javax.servlet.ServletContext",
					Mvcs.getServletContext());
			Velocity.init(props);
			log.info("Velocity Init Successful Ok !");
		} catch (IOException e) {
			log.error("Velocity Init Faild !");
			e.printStackTrace();
		}

	}
}
