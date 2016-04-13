package org.nutz.plugins.view.freemarker.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.nutz.lang.Times;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 执行时间标签
 * 
 */
public class CurrentTimeDirective implements TemplateDirectiveModel {

	@SuppressWarnings({ "rawtypes" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		Writer out = env.getOut();
		out.append(Times.format("yyyy-MM-dd HH:mm", Times.now()));
	}
}
