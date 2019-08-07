<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align='center'>Add Account</h2>
	<hr color="red">
	<center>
	<form action="/uservlet/act/add" method="">
		<table>
			<tr>
				<td>act_no</td>
				<td><input name="actNo"></td>
			</tr>
			<tr>
				<td>balance</td>
				<td><input name="balance"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">add</td>
				<td><input type="submit" value="add"></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>