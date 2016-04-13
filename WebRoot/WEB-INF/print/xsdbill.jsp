<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售票据打印</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"
	scrollerY="false" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--lodop打印控件start-->
<script src="<%=path%>/libs/thirdparty/lodop/LodopFuncs.js"
	type="text/javascript"></script>
<object id="LODOP_OB"
	classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0"
	height="0" style="line-height: 0px;">
	<embed id="LODOP_EM" type="application/x-print-lodop" width="0"
		height="0" style="line-height:0px;"></embed>
</object>
<!--lodop打印控件end-->
<!--打印的表格样式start-->
<style id="printStyle">
.tablePrint {
	border-collapse: collapse;
	border: 1px solid #000000;
	width: 100%;
	background-color: White;
}

.tablePrint th {
	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	word-wrap: normal;
	word-break: keep-all;
	overflow: hidden;
	border-color: #000000;
	height: 32px;
	padding: 0 2px 0 4px;
	background-color: #cccccc;
	color: #000000;
	font-weight: normal;
	line-height: 32px;
	text-align:center;
}

.tablePrint td {
	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	border-color: #000000;
	height: 30px;
	padding: 1px 2px 1px 4px;
	text-align:center;
}

.tablePrint .printHide {
	display: none;
}

h2, .top_info1, .top_info2 {
	text-align:center;
}
</style>
<style>
#p_content {
	width:96%;
}
</style>
<!--打印的表格样式end-->
</head>
<body>
	<div>
		<div style="display: none;" id="content">
			<img src="/qui/sample/thirdparty/lodop/view2.jpg" />
		</div>
		注意：需要连接打印机才能正常测试。如果没有测试条件，可以 <a style="color: red" onclick="popWin()">点击这里</a>查看实际效果截图，或者
		<a
			href="http://qui-frame.googlecode.com/files/PDFCreator-0_9_9_setup.exe"
			style="color: red">点击下载</a>并安装虚拟打印机进行测试。 <br />如果安装了虚拟打印机，还有一个额外的功能，就是能够把要打印的数据直接输出成PDF文件（在打印预览窗口点击打印按钮）。
	</div>
	<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
		<div class="center">
			<div class="left">
				<div class="right">
					<div class="padding_top5 padding_left10">
						<a href="javascript:;" onclick="printHandler()"><span
							class="icon_print">打印本页数据</span></a>
						<!-- <div class="box_tool_line"></div>
						<a href="javascript:;" onclick="printHandler2()"><span
							class="icon_print">打印选中数据</span></a>
						<div class="clear"></div> -->
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="p_content">
		<div id="content_top">
		<h2>湖南省醴陵市金旺出口烟花厂发货清单</h2><hr />
		<div class="top_info1"><table><tr><td>地址：南桥镇凤形村</td><td>电话：0731-23709499</td><td>&nbsp;&nbsp;手机：13508499449</td></tr></table></div>
		
		<div class="top_info2">收货单位：<span>湖南省长沙市麓谷大道100号 </span>   <span></span>第 100 号</div>
		</div>
		<div id="content_table">
		<table class="tableStyle" mode="list" id="myTable">
			<tr>
				<th class="ali02">货号</th>
				<th class="ali02">品名</th>
				<th class="ali02">规格</th>
				<th class="ali02">含量</th>
				<th class="ali02">数量</th>
				<th class="ali02">单价</th>
				<th class="ali02">件价</th>
				<th class="ali02">金额</th>
				<th class="ali02">备注</th>
			</tr>
			<c:forEach var="item" items="${obj.items }" varStatus="status">
			<tr>
				<td class="ali02"></td>
				<td class="ali02">${item.goodsName}</td>
				<td class="ali02">${item.goodsName}</td>
				<td class="ali02">${item.goodsName}</td>
				<td class="ali02">${item.goodsAmount}</td>
				<td class="ali02">${item.goodsUnitPrice}</td>
				<td class="ali02">${item.goodsName}</td>
				<td class="ali02">${item.goodsSum}</td>
				<td class="ali02">${item.comment}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan=2 class="ali02">合计</td>
				<td class="ali02"></td>
				<td class="ali02"></td>
				<td class="ali02"></td>
				<td class="ali02"></td>
				<td class="ali02"></td>
				<td class="ali02">${obj.main.saleAmount}</td>
				<td class="ali02"></td>
			</tr>
			<tr>
				<td colspan=10>
					承运车号：王承运  &nbsp;&nbsp;&nbsp;&nbsp;司机：利斯基&nbsp;&nbsp;&nbsp;&nbsp; 提货人：王宝林 &nbsp;&nbsp;&nbsp;&nbsp;收货人：张效率
				</td>
			</tr>
		</table>
		</div>
		<div id="content_bottom">
			主管：&nbsp;<span>${obj.main.checker }</span>发货人：&nbsp;<span>小名</span>制单人：&nbsp;<span>${obj.main.inputUserName }</span>
		</div>
	</div>
	<script>
		function printHandler() {
			var LODOP = getLodop(document.getElementById('LODOP_OB'), document
					.getElementById('LODOP_EM'));
			var strBodyStyle = "<style>"+ document.getElementById("printStyle").innerHTML+ "</style>";
			var tableHtml,topHtml,bottomHtml;
			var tableObj = $('<table class="tablePrint"></table>')
			var tableCon = $('<div></div>');
			//打印内容 头部
			var topCon = $('<div></div>');
			topCon.append($("#content_top").html());
			topHtml = topCon.html();
			var topBodyHtml =  strBodyStyle + "<body>" +  topHtml + "</body>";
			console.log(topBodyHtml);
			
			//打印表格 内容 
			tableCon.append(tableObj);
			tableObj.append($("#myTable").html());
			tableHtml = tableCon.html();
			var strBodyHtml = strBodyStyle + "<body>" + tableHtml + "</body>";
			//打印底部 内容
			bottomHtml = $("#content_bottom").html();
			console.log(bottomHtml);
			
			LODOP.PRINT_INIT("销售出库单打印数据");
			LODOP.ADD_PRINT_HTM("5mm", 0, "99%", "96%",topBodyHtml);
			LODOP.ADD_PRINT_TABLE("40mm", 0, "99%", "96%", strBodyHtml);
			LODOP.ADD_PRINT_HTM("35%", 0, "99%", "96%",bottomHtml);
			LODOP.PREVIEW();
		}
		function printHandler2() {
			var $checkboxRows = $("#myTable").find("input[type=checkbox]");
			var isChecked = false;
			var tableObj = $('<table class="tablePrint"></table>')
			$checkboxRows.each(function() {
				if ($(this).attr("checked")) {
					tableObj.append($(this).parents("tr"));
					isChecked = true;
				}
			})
			if (!isChecked) {
				top.Dialog.alert('请至少选择一行');
				return;
			}
			var th = $('<thead><th>姓名</th><th>性别</th><th>年龄</th><th>工作</th><th>联系方式</th><th>住址</th><th>婚姻状况</th><th>备注</th></thead>');
			tableObj.prepend(th)
			var tableCon = $('<div></div>')
			tableCon.append(tableObj);
			var LODOP = getLodop(document.getElementById('LODOP_OB'), document
					.getElementById('LODOP_EM'));
			var strBodyStyle = "<style>"
					+ document.getElementById("printStyle").innerHTML
					+ "</style>";
			var tableHtml;
			tableHtml = tableCon.html();
			var strBodyHtml = strBodyStyle + "<body>" + tableHtml + "</body>";
			LODOP.PRINT_INIT("打印选中数据");
			LODOP.ADD_PRINT_TABLE(15, 0, "99%", "96%", strBodyHtml);
			LODOP.PREVIEW();
		}

		function popWin() {
			top.Dialog.open({
				InnerHtml : $("#content").html(),
				Title : "效果预览",
				Width : 820,
				Height : 520
			});
		}
	</script>
</body>
</html>