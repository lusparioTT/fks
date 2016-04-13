package commons.core.service;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

/**
 * Created by Timgise 2016年2月29日
 */
public abstract class BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Prev(els = @EL("$me.now()"))
	@Column(value = "create_time")
	protected Date createTime;

	@Comment(value = "是否可删除")
	@Column(hump = false, value = "is_delete")
	protected boolean idDelete;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isIdDelete() {
		return idDelete;
	}

	public void setIdDelete(boolean idDelete) {
		this.idDelete = idDelete;
	}

	@Override
	public String toString() {
		return String.format("/*%s*/%s", super.toString(),
				Json.toJson(this, JsonFormat.compact()));
	}

	public Date now() {
		return new Date();
	}

	private String uid() {
		return "";
	}
}
