package modules;

import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.plugins.view.freemarker.FreemarkerViewMaker;
import org.nutz.plugins.view.velocity.VelocityViewMaker;

//nutz mvc动作链配置
@ChainBy(args="/mvc/nutz-mvc-chain.js")
//应用启动以及关闭时的额外处理
@SetupBy(AppSetup.class)
//自动搜索子模块
@Modules(scanPackage=true)
//UTF-8编码格式
@Encoding(input="utf8",output="utf8")
//Ioc Bean的依赖关系配置 js文件和注解类的扫描包的声明
@IocBy(type=ComboIocProvider.class,args={"*js","ioc/",
      "*anno","modules",
      "*tx",
      "*org.nutz.plugins.view.freemarker.FreemarkerIocLoader",
      "*org.nutz.plugins.quartz.QuartzIocLoader"})
//Velocity JetbrickTemplate Freemarker模板配置
@Views(value={VelocityViewMaker.class,org.nutz.plugins.view.jetbrick.JetTemplateViewMaker.class,
		FreemarkerViewMaker.class})
//定义全局的过滤器 优先级为入口函数最高
@Filters({
})
//默认视图
@Ok("json:full")
//异常跳转
@Fail("jsp:error.500")
//本地化字符串设定
@Localization(value="msg/", defaultLocalizationKey="zh-CN")
public class MainModule {}
