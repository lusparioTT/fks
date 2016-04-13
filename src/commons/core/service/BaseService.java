package commons.core.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.service.EntityService;

public class BaseService<T> extends EntityService<T> {

	public BaseService() {
		super();
	}

	public BaseService(Dao dao) {
		super(dao);
	}

	public T fetch(long id) {
		return this.dao().fetch(this.getEntityClass(), id);
	}
	
	public List<T> query(){
		return this.dao().query(this.getEntityClass(), null);
	}
	protected T insertOne(T obj){
		return this.dao().insert(obj);
	}
}
