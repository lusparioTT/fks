package modules.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.TableIndexes;

import commons.core.service.BasePojo;

/**
 * Created by Timgise 2016年2月29日
 */
@Table(value = "sys_user")
@TableIndexes(value = { @Index(name = "INDEX_UID", fields = { "uid" }, unique = true) })
public class Sys_User extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id(auto = true)
	@Column(value = "sys_uid")
	// @ColDefine(type=ColType.INT)
	private long uid;

	@Column(value = "sys_uname")
	@ColDefine(type = ColType.VARCHAR, width = 64)
	private String uname;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
