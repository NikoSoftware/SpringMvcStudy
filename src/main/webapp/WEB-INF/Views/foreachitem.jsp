<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 2017/9/5
  Time: 下午7:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>

        table{
            font-family: Arial;
            color: black;
            align: center;
        }


        h4{
            font-family: Arial;
            color: fuchsia;
            align: center;
        }



    </style>

</head>
<body align=center>

<h4>这是标题</h4>
<hr>


<table border="1px" align=center>

    <tr>
        <td>id</td>
        <td>name</td>
        <td>websiteId</td>
    </tr>
    <c:forEach var="person" items="${persons}" varStatus="status">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.websiteid}</td>

        </tr>
    </c:forEach>


</table>

<hr>

<h4>图片上传</h4>

<form action="/Test/updateImage" method="post" enctype="multipart/form-data">

    选择文件：<input type="file" name="imageFile">
    <input type="submit" value="提交">

</form>

</body>
</html>
