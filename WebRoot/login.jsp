<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="author" content="timgise">
    <title>登录</title>
    <!--提示框效果-->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <!--fontawesome-->
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/fontawesome/4.4.0/css/font-awesome.min.css
">
    <!-- fort js css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fort.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<body>

<div class="form-wrapper">
	<h1 class="h1h">Fort.js</h1>
	<form name="form" action="#">
		<div class="form">
			<div class="form-item">
				<input type="text" name="text" required="required" placeholder="Name" autocomplete="off">
			</div>
			<div class="form-item">
				<input type="text" name="text" required="required" placeholder="Username" autocomplete="off">
			</div>
			<div class="form-item">
				<input type="password" name="password" required="required" placeholder="Password" autocomplete="off">
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="Sign In" value="Test It Out">
				<ul>
					<li class="lil">
					<p class="view">
						<a href="https://github.com/Colourity/Fort.js" id="ref">View on GitHub</a>
					</p>
					</li>
					 or
					<li>
					<p class="view">
						<a href="https://twitter.com/intent/tweet?text=Fort-js+-+A+Modern+Progress+Bar+for+Form+Completion.&url=http://bit.ly/1gQQ4V8" id="ref">Share</a>
					</p>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>



<!--...-->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>
<!-- fort js -->
<script src="${pageContext.request.contextPath}/js/fort.min.js"></script>
<script>
      Fort.flash("#009DFF", "#000", "#6638F0");
</script>
</body>
</html>