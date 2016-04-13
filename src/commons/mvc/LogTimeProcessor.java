package commons.mvc;

import javax.servlet.http.HttpServletRequest;

import org.nutz.lang.Stopwatch;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

public class LogTimeProcessor extends AbstractProcessor {

	private static final Log LOG = Logs.get();

	public LogTimeProcessor() {
	}

	@Override
	public void process(ActionContext ac) throws Throwable {
		Stopwatch sw = Stopwatch.begin();
		try {
			doNext(ac);
		} finally {
			sw.stop();
			if (LOG.isDebugEnabled()) {
				HttpServletRequest req = ac.getRequest();
				LOG.debugf("[%4s]URI=%s %sms", req.getMethod(),
						req.getRequestURI(), sw.getDuration());
			}
		}
	}

}
