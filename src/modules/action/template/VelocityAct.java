package modules.action.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * Created by Timgise 2016年3月1日
 */
@At("/velocity")
@IocBean(name="velocityAct")
public class VelocityAct {

	@At("/hello")
	@Ok("vm:hello")
	public Object hello(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		// return Lang.context().set("name", "lebao");
		map.put("date", new Date());
		map.put("request", req);
//		Lang.context().set("name", "大花猫");
		return map;
	}

	@At
	@Ok("vm:velocity.list.vm")
	public Object list() {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);

		return list;
	}
	//Bootstrap表格插件示例
	@At("/3")
	@Ok("vm:bootstrap-table.bstable.vm")
	public void tableExample(){}

}
