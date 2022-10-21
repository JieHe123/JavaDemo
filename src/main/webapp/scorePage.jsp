<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 19/10/2022
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>score</title>
</head>
<body>
<c:forEach items="${arr}" var="item">
    科目：${item.getA()}<br>&nbsp&nbsp&nbsp&nbsp成绩：${item.getB()}<br>

</c:forEach>
</body>
</html>
