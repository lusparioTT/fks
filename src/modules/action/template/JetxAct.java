package modules.action.template;

import javax.servlet.http.HttpServletRequest;

import modules.service.SysUserService;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import commons.mvc.BaseModule;

/**
 * Created by Timgise 2016年3月2日
 * 
 * 入口方法的nutzMvc注解顺序 从下至上 先AT 再其他例如Filtes 最后OK
 * 
 */

//JetbrickTemplate模板集成示例
@IocBean
@At("/jetx")
public class JetxAct extends BaseModule{
	
	@Inject SysUserService sysUserService;
	
	@At
	@Ok("jetx:/WEB-INF/template/jetx/hello.jetx")
	public void hello(HttpServletRequest request){
		logger.debug("hello Jetbrick...");
	}
	
	@At
	//@Ok("jetx:/WEB-INF/template/jetx/uikit/index")
	@Ok("jetx:uikit.index")
	public void uikit(HttpServletRequest request){
		
		logger.debug("协议(HTTP)信息：" + request.getProtocol());
		
	}
	
	@At("/user/srv")
	@Ok("json")
	public Object user_service(HttpServletRequest request){
		
		logger.debug("参数id=" + request.getParameter("id"));
		return sysUserService.query(null, null);
		
	}
	
	@Ok("jetx:uikit.linechart")
	@At("/linechart")
	public void echart_linechart(){}
}
