package modules.service;

import static modules.util.RedisInterceptor.*;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean
public class RedisService {

	@Aop("redis")
	public void set(String key, String val) {
		jedis().set(key, val);
	}

	@Aop("redis")
	// 加上这个拦截器后jedis()才能返回Jedis实例哦
	public String get(String key) {
		return jedis().get(key);
	}
}
