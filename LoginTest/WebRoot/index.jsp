<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body style="color:red">
		<h1 align="center">
			<em>登录界面</em>
		</h1>
		<hr>
		<form name="login" action="./servlet/LoginCtrl" method="post">
		<table align="center">
				<tr>
					<td>
						请输入用户名：
					</td>
					<td>
						<input type="text" name="userName">
					</td>
				</tr>
				<tr>
					<td>
						请输入密码：
					</td>
					<td>
						<input type="text" name="userPassword">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" value="确定">
					</td>
					<td align="center">
						<input type="reset" value="重置">
					</td>
				</tr>
				</table>
		</form>
		
	</body>
</html>
