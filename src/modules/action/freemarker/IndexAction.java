package modules.action.freemarker;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
@At("/fm")
public class IndexAction {
	
	@At("/index")
	@Ok("fm:template.ftl.main.index")
	public void index(HttpServletRequest request){}
	
	
	
	@At
	@Ok("fm:template.ftl.test")
	public void test(){}
}
