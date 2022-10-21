<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 10/10/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        #frame {
            width: 600px;
            height: 400px;
            background-color: bisque;
            margin: 400px auto;
            position: relative;
        }


        #ul1 {
            width: 400px;
            height: 250px;
            position: absolute;
            background-color: burlywood;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            margin: auto;

        }

        #ul1 li {
            list-style-type: none;
            margin: auto;
        }
    </style>
</head>
<body>
<div id="frame">

    <ul id="ul1">
        <li>Username:&nbsp <input type="text" id="u_id"><br></li>
        <li>Password:&nbsp <input type="password" id="u_pwd"><br></li>
        <li>
            <button id="bnt01">Reset</button> &nbsp;<button id="bnt02">Login</button>
        </li>
    </ul>
    <span id="error">${error}</span>
</div>

<script>
    let btn001 = document.getElementById("bnt02");
    btn001.onclick = function () {
        let id_str = document.getElementById("u_id").value;
        if (id_str == null || id_str == "") {
            document.getElementById("error").innerHTML = "The id can't be empty!"
            return;
        }
        let psd_str = document.getElementById("u_pwd").value;
        if (psd_str == null || psd_str == "") {
            document.getElementById("error").innerHTML = "The password can't be empty!"
            return;
        }
        window.location.href = "login?html__u_id=" + id_str + "&html_u_pwd=" + psd_str;

    }

</script>

</body>
</html>
