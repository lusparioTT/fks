package modules.action;

import javax.servlet.http.HttpServletRequest;

import modules.domain.Sys_User;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.ViewModel;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import commons.sysLog.BaseLogger;

@IocBean(name="NMTA")
@At(top=true,value={"/nutz","/nut"})
public class NutzMvcTestAction extends BaseLogger {
	
	@At(value={"/get","/getM"})
	@GET
	public String requestMethod(HttpServletRequest request){
		return request.getMethod();
	}
	
	@At("/post")
	@POST
	public String requestPostMethod(){
		return Mvcs.getName();
	}
	
	@At("/form/u")
	@Ok("json:full")
	public Object formFieldAdaptor(@Param("::u")Sys_User user){
		
		return user;
		
	}
	//ViewModuel用作传递视图渲染所需的值
	@At
	@Ok("re:jsp:/login.jsp")
	public String reView(ViewModel viewModel){
		if (Strings.isEmpty("")) {
			return null;
		}
		viewModel.addv("users", null);//页面取值应该是${obj.xxx.xxx}
		return "jsp:/login.jsp";
	}
	
	
}
