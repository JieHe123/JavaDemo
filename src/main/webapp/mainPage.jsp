<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 14/10/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script>

        function search() {
            let v23 = document.getElementById("fileId").value;
            window.location.href = "mainServelet?v=" + v23 + "&id=${user.getU_id()}";
        }

        function goShow(uid) {
            let v = document.getElementById("fileId").value;
            window.location.href = "showServelet?v=" + v + "&id=" + uid;
            //let v = document.getElementById("fileId").value;
            //window.location.href = "showServelet?id=" + uid;
        }


    </script>
<style>.site-header {
    background-color: rgba(0, 0, 0, .85);
    -webkit-backdrop-filter: saturate(180%) blur(20px);
    backdrop-filter: saturate(180%) blur(20px);
}
.site-header a {
    color: #999;
    transition: ease-in-out color .15s;
}
.site-header a:hover {
    color: #fff;
    text-decoration: none;
}</style>

</head>
<body>

<nav class="site-header sticky-top py-1">
    <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        </a>
        <a class="py-2 d-none d-md-inline-block" href="#">Tour</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Product</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Features</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Enterprise</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Support</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Pricing</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Cart</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Name: ${user.getU_name()} ID: ${user.getU_id()}</a>
    </div>
</nav>


<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center">

<div id="search">
    <div id="inner_s">
        <input type="text"  id="fileId">&nbsp;&nbsp;
        <button class="btn btn-primary" onclick="search(document.getElementById('fileId').value)">查询
        </button>
    </div>
</div>

<div class="col-md-5 mx-auto my-5">
    <table id="table"  class="table bg-light">
        <thead >
        <tr>
            <td scope="col" class="py-3 px-6">学生id</td>
            <td scope="col" class="py-3 px-6">学生名字</td>
            <td scope="col" class="py-3 px-6">学生电话</td>
            <td scope="col" class="py-3 px-6">查看成绩</td>
            <td scope="col" class="py-3 px-6">操作</td>
        </tr>
        </thead>
        <c:forEach items="${arr}" var="item">
        <tr >
            <td>${item.getU_id()}</td>
            <td>${item.getU_name()}</td>
            <td>${item.getU_phone()}</td>
            <td>
                <button class="btn btn-success" onclick="goShow(${item.getU_id()})">查看成绩</button>
            </td>
            <td>
                <button class="btn btn-primary">修改</button>
                <button class="btn btn-danger">删除</button>
            </td>
        </tr>

        </c:forEach>
</div>

</div>
</body>
</html>


