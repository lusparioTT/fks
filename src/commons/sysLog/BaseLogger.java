package commons.sysLog;

import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * Log基类 使用类继承此类即可
 * Created by Timgise 2016年3月10日
 */
public class BaseLogger {
	public Log logger = Logs.getLog(getClass());
}
