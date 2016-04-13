package modules.service;

import java.util.List;

import modules.domain.Sys_User;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import commons.core.service.BaseService;

@IocBean(name="sysUserService",args={"refer:dao"})
public class SysUserService extends BaseService<Sys_User> {
	
	public SysUserService(Dao dao){
		super(dao);
	}
	
	public Sys_User findUserById(long id){
		return fetch(id);
	}
	
	public List<Sys_User> findUserAll(){
		return query();
	}
	
	public Sys_User insert(Sys_User user){
		return insertOne(user);
	}
}
