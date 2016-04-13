var ioc = {
	//属性文件加载
	config : {
		type : "org.nutz.ioc.impl.PropertiesProxy",
		fields : {
			paths : [ "props/","db.properties","redis.properties"]
		}
		//args : ["db.properties","redis.properties"]
	},
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			create : 'init',
			depose : 'close'
		},
		fields : {
			driverClass : {
				java : "$config.get('db-driver')"
			},
			jdbcUrl : {
				java : "$config.get('db-url')"
			},
			username : {
				java : "$config.get('db-username')"
			},
			password : {
				java : "$config.get('db-password')"
			},
			initialSize : 5,
			maxActive : 50,
			//maxIdle : 10, //deprecated
			defaultAutoCommit : false,
			timeBetweenEvictionRunsMillis : 3600000,
			minEvictableIdleTimeMillis : 3600000,
			filters : "mergeStat",
            connectionProperties : "druid.stat.slowSqlMillis=2000"
		}
	},

	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ],
		fields : { executor : {refer : "cacheExecutor"} }
	},
	//	缓存执行器
	cacheExecutor : {
		type : "org.nutz.plugins.cache.dao.CachedNutDaoExecutor",
		fields : {
			cacheProvider : {refer:"cacheProvider"},
			cachedTableNames : [ 
			    "sys_user" ]
		}
	},
	// 基于Ehcache的DaoCacheProvider
	cacheProvider : {
		type : "org.nutz.plugins.cache.dao.impl.provider.EhcacheDaoCacheProvider",
		fields : {
			cacheManager : {
				refer : "cacheManager"
			}
		// 引用ehcache.js中定义的CacheManager
		},
		events : {
			create : "init"
		}
	}
};
