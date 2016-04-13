package cn.timgise.wsclient;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import cn.timgise.ws.HelloWorldService;

public class HelloWorldServiceClient {

	private HelloWorldServiceClient() {
	}

	public static void main(String args[]) throws Exception {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		if (args != null && args.length > 0 && !"".equals(args[0])) {
			factory.setAddress(args[0]);
		} else {
			factory.setAddress("http://localhost:8888/ws/hello");
		}
		HelloWorldService client = factory.create(HelloWorldService.class);
		System.out.println("Invoke substract()....");
		System.out.println(client.substract(2, 1));
		System.exit(0);
	}
}
