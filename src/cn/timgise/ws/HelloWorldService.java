package cn.timgise.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {
	@WebMethod
	public int multiply(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

	@WebMethod
	public int substract(@WebParam(name = "a") int a,
			@WebParam(name = "b") int b);
}
