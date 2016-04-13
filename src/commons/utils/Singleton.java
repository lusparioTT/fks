package commons.utils;

/**
 * Created by Timgise 2016年3月6日 单例实现-线程安全
 */
public class Singleton {
	// Private constructor prevents instantiation from other classes
	private Singleton() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
