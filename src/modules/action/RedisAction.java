package modules.action;

import javax.servlet.http.HttpServletRequest;

import modules.service.RedisService;

import org.nutz.http.Request;
import org.nutz.http.Request.METHOD;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;

import commons.mvc.BaseModule;

@IocBean
@At(value="/jedis")
public class RedisAction extends BaseModule{
	
	
	@Inject RedisService redisService;
	
	@At
	public String test(HttpServletRequest request){
		logger.debug(request.getMethod());
		return "OK";
	}
	
	@At(key="a",value="/jv",top=false,methods="post,get")
	//@GET
	public Object jedisView(){
		String[] color = {"red","green","pink"};
//		redisService.set("", color);
		logger.debug(redisService.get("MY_NAME"));
		
		return redisService.get("MY_NAME");
	}
	
	
	
	
}
