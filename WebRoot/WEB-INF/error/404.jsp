<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=9" ></meta>	
		<style type="text/css">
		a {
			behavior:url(<%=path%>/libs/js/method/focus.htc)
		}
		.noPageBg{
			background-image:url(<%=path%>/libs/images/404.jpg);
    		background-repeat:no-repeat; 
    		background-position:50% 50%;
		}
		</style>
</head>
<body>
<script>
function customHeightSet(contentHeight){
	$(".noPageBg").height(contentHeight);
}
</script>
</head>
<body>
<div class="noPageBg">
</div>
</body>
</html>