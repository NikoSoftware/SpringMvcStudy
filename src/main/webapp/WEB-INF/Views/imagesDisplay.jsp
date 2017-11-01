<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 2017/9/8
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>

        function url() {
            document.getElementById("url").innerHTML=window.location.href

        }


    </script>

    <STYLE>

        .imgClass{
            float: left;
            width: 200px;
            height: auto;
            padding: 20px;
        }

    </STYLE>

</head>
<body  onload="url()">


<P id="url"></P>


<c:forEach var="image" items="${imageDatas}" varStatus="status">

    <img class="imgClass" src="${image.imagepath}">


</c:forEach>

</body>
</html>
