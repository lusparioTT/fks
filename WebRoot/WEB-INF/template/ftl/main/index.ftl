<!DOCTYPE html>
<html lang="zh-CN">
  <head>
     <#include "/template/ftl/include/head.ftl" />
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">项目名称</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">仪表盘</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">个人信息</a></li>
            <li><a href="#">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="搜索...">
          </form>
        </div>
      </div>
    </nav>
	
    <div class="container-fluid">
      <div class="row">
      	<#-- 侧边栏 菜单 -->
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">菜单预览 <span class="sr-only">(current)</span></a></li>
            <li><a href="#"><span class="glyphicon glyphicon-align-left" aria-hidden="true"></span> 报告</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> 分析</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-apple" aria-hidden="true"></span> 导出</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href=""><span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span> 数据监控</a></li>
            <li><a href=""><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span> 文件夹</a></li>
            <li><a href=""><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 支付接口</a></li>
            <li><a href=""><span class="glyphicon glyphicon-signal" aria-hidden="true"></span> 代码生成</a></li>
            <li><a href=""><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 大数据</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 网关配置</a></li>
            <li><a href=""><span class="glyphicon glyphicon-send" aria-hidden="true"></span> 防火墙</a></li>
            <li><a href=""><span class="glyphicon glyphicon-envelop" aria-hidden="true"></span> </a></li>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <#-- 传送带 -->
        <#include "/template/ftl/include/carousel.ftl"/>
        </div>
        
        </div>
      </div>
      
    </div>

   <#include "/template/ftl/include/script.ftl" />
  </body>
</html>
