<%--
  Created by IntelliJ IDEA.
  User: STRIDE
  Date: 2020/12/7
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form action="usersServlet.do" method="post">
        <input type="hidden" name="flag" value="addUsers"/>
        用户姓名：<input type="text" name="username"/><br/>
        用户性别：<input type="text" name="usersex"/><br/>
        <input type="submit" value="OK">
    </form>
</body>
</html>
