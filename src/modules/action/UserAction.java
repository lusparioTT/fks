package modules.action;

import modules.domain.Sys_User;
import modules.service.SysUserService;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import commons.mvc.BaseModule;

/**
 * Created by Timgise 2016年3月19日
 */
@IocBean
@At("/usr")
public class UserAction extends BaseModule {
	
	@Inject SysUserService sysUserService;
	
	@At("/all")
	public Object usrAll(){
		return sysUserService.findUserAll();
	}
	
	@At("/add")
	public Sys_User addOne(){
		Sys_User user=new Sys_User();
		user.setUname("麦当劳");

		return sysUserService.insert(user);
	}
}
