<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>结果页面</title>    

  </head>
  
  <body>
  <h1 algin="center"> 结果页面</h1>
  <hr>
      <% String msg = (String)request.getAttribute("MSG"); %>
      <%= msg %>
   <hr>
      <a href="../index.jsp" > 返回</a>
  </body>
</html>
