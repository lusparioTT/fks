package org.nutz.plugins.view.freemarker;

import java.util.ArrayList;
import java.util.List;

import org.nutz.lang.Lang;

public class FreemarkerDirectiveFactory {

	private List<FreemarkerDirective> list = new ArrayList<FreemarkerDirective>();

	private String freemarker;

	private String suffix;

	private FreemarkerDirective[] objs;

	public FreemarkerDirectiveFactory() {
	}

	public FreemarkerDirectiveFactory(FreemarkerDirective... objs) {
		this.objs = objs;
	}

	public List<FreemarkerDirective> getList() {
		return list;
	}

	public String getFreemarker() {
		return freemarker;
	}

	public String getSuffix() {
		return suffix;
	}

	public void init() {
		if (Lang.isEmptyArray(objs)) {
			return;
		}
		for (FreemarkerDirective freemarkerDirective : objs) {
			list.add(freemarkerDirective);
		}
	}

	public FreemarkerDirectiveFactory create(FreemarkerDirective... objs) {
		if (Lang.isEmptyArray(objs)) {
			return this;
		}
		for (FreemarkerDirective freemarkerDirective : objs) {
			list.add(freemarkerDirective);
		}
		return this;
	}
}
