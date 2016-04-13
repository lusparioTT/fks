package commons.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * @author Administrator
 * Servlet implementation class HttpServletInfo
 */
public class HttpServletInfo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(HttpServletInfo.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServletInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("call method doGet ...");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("call method doPost ...");
		
		log.debug("当前线程名称："+Thread.currentThread().getName());
		
		String encoding_str = request.getCharacterEncoding();
		log.debug("编码字符集："+encoding_str);
		
		Enumeration<String> enumeration= request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			log.debug(request.getHeader(enumeration.nextElement()));
		}
		
		//----------------------------------------------------------------------
		log.debug("$getContextPath" + request.getContextPath());
		log.debug("$getServletContext()$getContextPath()" +request.getServletContext().getContextPath());
		log.debug("$getPathInfo()" + request.getPathInfo());
		
		/*响应到客户端*/
		
//		PrintWriter writer = response.getWriter();
//		writer.print("good evenning ...");
		
//		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
		response.sendRedirect(request.getContextPath()+"/bootstrap-table/invited_record.html");
	}

}
