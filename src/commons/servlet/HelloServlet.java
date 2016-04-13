package commons.servlet;

import javax.servlet.ServletConfig;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import cn.timgise.ws.HelloWorld;
import cn.timgise.ws.HelloWorldServiceImpl;

/**
 * Servlet implementation class HelloServlet Use Apache CXF SOAP Without Spring
 */
public class HelloServlet extends CXFNonSpringServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void loadBus(ServletConfig sc) {
		// TODO Auto-generated method stub
		super.loadBus(sc);

		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);

		ServerFactoryBean svrFactory = new ServerFactoryBean();
		svrFactory.setServiceClass(HelloWorld.class);
		svrFactory.setAddress("http://localhost:9000/Hello");
		svrFactory.setServiceBean(new HelloWorldServiceImpl());
		// svrFactory.getServiceFactory().setDataBinding(new
		// AegisDatabinding());
		svrFactory.create();

		// Endpoint.publish("/hello", new HelloWorldServiceImpl());

	}

}
