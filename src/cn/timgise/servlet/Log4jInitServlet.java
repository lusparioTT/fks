package cn.timgise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Timgise 2016年4月16日
 */
public class Log4jInitServlet extends HttpServlet {

	private static final long serialVersionUID = -5713541652865519571L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// super.init();
		String prefix = getServletContext().getRealPath("/");

		String file = getInitParameter("log4j-init");

		if (file != null) {
			
			PropertyConfigurator.configure(prefix + file);
			
		}
		
	}

}
