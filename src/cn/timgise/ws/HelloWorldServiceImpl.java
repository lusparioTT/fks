package cn.timgise.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.timgise.ws.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
	@Override
	public int multiply(int a, int b) {
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

}
