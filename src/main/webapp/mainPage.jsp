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
    <style>
        #head_ {
            height: 100px;
            width: 100%;
            background-color: slategray;
        }

        #personFile {
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }

        #search {
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }

        #inner_s {
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top: 25px;
            padding-left: 45%;
        }

        #table {
            margin-left: 30%;
            margin-top: 30px;
        }

        td {
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding: 1px;

        }

    </style>
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


</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span>
    </div>
</div>


<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId">&nbsp;&nbsp;
        <button style="font-size: 18px; height: 28px;" onclick="search(document.getElementById('fileId').value)">查询
        </button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr>
            <td>学生id</td>
            <td>学生名字</td>
            <td>学生电话</td>
            <td>查看成绩</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${arr}" var="item">
        <tr>
            <td>${item.getU_id()}</td>
            <td>${item.getU_name()}</td>
            <td>${item.getU_phone()}</td>
            <td>
                <button style="color: chocolate" onclick="goShow(${item.getU_id()})">查看成绩</button>
            </td>
            <td>
                <button style="color: chocolate">修改</button>
                <button style="color: chocolate">删除</button>
            </td>
        </tr>

        </c:forEach>
</div>


</body>
</html>

