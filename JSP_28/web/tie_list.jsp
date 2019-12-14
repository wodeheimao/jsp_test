<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/bs.jsp" %>

<html>
<head>
    <title>贴</title>
    <style>
        #form1 {
            margin-bottom: 10px;
        }

        table {
            text-align: center;
        }
        th{
            text-align: center;
        }
    </style>
    <script>


    </script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>帖子列表</h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div>帖子列表</div>
        </div>
        <div class="panel-body">
            <div class="row">
                <table class="table table-bordered table-hover table-striped">
                    <tr>
                        <th>编号</th>
                        <th>板块名称</th>
                        <th>标题</th>
                        <th>发布人</th>
                        <th>发表时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${tieList}" var="t">
                        <tr>
                            <td>${t.tid}</td>
                            <td>${t.pname}</td>
                            <td><a href="#">${t.title}</a></td>
                            <td>${t.tname}</td>
                            <td>${t.pubdate}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/tie?cmd=toupdate&tid=${t.tid}" class="btn btn-default">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
