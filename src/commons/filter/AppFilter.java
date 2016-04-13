package commons.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutFilter;

/*
 * 定義自己的nutz應用入口過濾器
 */
public class AppFilter extends NutFilter {
	private static final Log LOG = Logs.getLog(AppFilter.class);
	protected Set<String> prefixs = new HashSet<String>();

	public void init(FilterConfig conf) throws ServletException {
		super.init(conf);
		prefixs.add(conf.getServletContext().getContextPath() + "/druid/");
		prefixs.add(conf.getServletContext().getContextPath() + "/rs/");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			String uri = ((HttpServletRequest) req).getRequestURI();
			for (String prefix : prefixs) {

				LOG.debug(prefix);

				if (uri.startsWith(prefix)) {
					chain.doFilter(req, resp);
					return;
				}
			}
		}
		super.doFilter(req, resp, chain);
	}
}
