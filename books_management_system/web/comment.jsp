<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/bs.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        div {
            border: 1px lightblue solid;
            margin: 10px 0;
        }
    </style>
    <title>学生列表</title>
    <script>
      /*  $(function () {
            $("#rest_btn").click(function () {
                $("#form1")[0].reset();
            })
        })*/
    </script>

</head>

<body>
<div class="container">
    <div class="page-header text-center">
        <h3>
            书籍的评论
        </h3>
    </div>
    <div id="div1" >
        <form action="${pageContext.request.contextPath}/comment?cmd=add" method="post" id="form1" >
            <input type="hidden" name="bno" value="${param.bno}">
            <table class="table table-bordered table-condensed">
                <tr>
                    <td style="width: 10%" >标题:</td>
                    <td style="width: 90%;">
                        <input type="text" name="ctitle" width="400px">
                    </td>
                </tr>
                <tr>
                    <td>推荐级别:</td>
                    <td>
                        <input type="radio" name="isre" value="推荐">推荐
                        <input type="radio" name="isre" value="一般">一般
                        <input type="radio" name="isre" value="不推荐">不推荐
                    </td>
                </tr>
                <tr style="height: 200px">
                    <td>内容:</td>
                    <td>
                        <textarea name="connent" style="width: 400px;height: 200px;"></textarea>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="text-center">
                        <input type="submit" value="提交" class="btn btn-sm btn-info">
                        &nbsp; &nbsp; &nbsp;
                        <input type="reset" value="重置" id="rest_btn" class="btn btn-sm btn-info">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="div2">
        <c:forEach items="${commentbs}" var="comment">
            <table class="table table-bordered">
                <tr>
                    <td style="width: 10%">标题:</td>
                    <td style="width: 90%;">${comment.ctitle}</td>
                </tr>
                <tr>
                    <td>推荐级别:</td>
                    <td>${comment.isre}</td>
                </tr>
                <tr>
                    <td>内容:</td>
                    <td>${comment.content}</td>
                </tr>
                <tr>
                    <td>发表时间:</td>
                    <td>${comment.cdate}</td>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>
</body>
</html>