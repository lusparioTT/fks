/**
 * Copyright 2013-2015 Guoqiang Chen, Shanghai, China. All rights reserved.
 *
 *   Author: Guoqiang Chen
 *    Email: subchen@gmail.com
 *   WebURL: https://github.com/subchen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nutz.plugins.view.jetbrick;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import jetbrick.template.web.JetWebContext;
import jetbrick.template.web.JetWebEngine;

import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.mvc.view.AbstractPathView;

/**
 * nutz与JetTemplate集成
 */
public final class JetTemplateView extends AbstractPathView {

	public JetTemplateView(String value) {
		super(value);
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Throwable {
		JetEngine engine = JetWebEngine.getEngine();

		String charsetEncoding = engine.getConfig().getOutputEncoding().name();
		resp.setCharacterEncoding(charsetEncoding);
		if (resp.getContentType() == null) {
			resp.setContentType("text/html; charset=" + charsetEncoding);
		}

		try {
			JetTemplate template = engine
					.getTemplate(fixPath(evalPath(req, obj)));
			JetWebContext context = new JetWebContext(req, resp);
			template.render(context, resp.getOutputStream());
		} catch (IOException e) {
			throw Lang.wrapThrow(e);
		}
	}

	private static final String SUFFIX = ".jetx";

	private String fixPath(String evalPath) {
		System.out.println("nutz视图路径：" + evalPath);
		// 参数为空null或者为空串
		if (Strings.isBlank(evalPath)) {
			return evalPath;
		}

		if (!(evalPath.charAt(0) == '/')) {
			// 分隔符为'.' 替换为'/'
			evalPath = evalPath.replace(".", "/");
		}
		// nutz视图路径无后缀的情况下添加模板后缀，
		if (!evalPath.endsWith(SUFFIX)) {
			evalPath += SUFFIX;
		}
		System.out.println("修复后的模板路径：" + evalPath);
		return evalPath;
	}
}
