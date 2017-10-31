<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 2017/10/31
  Time: 上午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script>



    function showHint(str){
        if(str.length == 0){
            return
        }


        $.ajax({

            type:"POST",
            url:"/Test/getZxingImage?imageInfo="+str,
            success:function (result) {


              $("#img").attr('src',result + "?id=" + Math.random());


            },
            error:function (jqXHR) {
                alert("发生错误"+jqXHR.status);
            }

        });

//
//        xmlhttp = new XMLHttpRequest();
//
//        xmlhttp.onreadystatechange = function () {
//
//            if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
//
//                document.getElementsByName("img").src = xmlhttp.responseText + "?id" + Math.random();
//                document.getElementsByName("text").innerHTML = xmlhttp.responseText + "?id" + Math.random();
//            }
//
//        }
//
//        xmlhttp.open("post","/Test/getZxingImage?imageInfo="+str,true);
//        xmlhttp.send();


    }






</script>

<head>
    <title>Title</title>
</head>
<body>


<form action="/Test/getZxing" target="_self" method="post" >

    <label>二维码信息：</label>
    <input type="text" name="imageInfo" onkeypress="showHint(this.value)">
    <input type="submit" value="提交">

</form>

<IMG id = "img"   src="${imagePath}">

</body>
</html>
