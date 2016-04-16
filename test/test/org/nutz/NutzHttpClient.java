package test.org.nutz;

import org.nutz.http.Http;

/**
 * Created by Timgise 2016年4月16日
 */
public class NutzHttpClient {

	public static void main(String[] args) throws Throwable {
		System.out.println(Http.get("http://g.cn").getContent());
	}
}
