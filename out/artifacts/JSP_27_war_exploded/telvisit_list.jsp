<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/bs.jsp" %>

<html>
<head>
    <title>回访</title>
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
        <h3>回访信息列表</h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div>回访信息列表</div>
        </div>
        <div class="panel-body">
            <div class="row">
                <table class="table table-bordered table-hover table-striped">
                    <tr>
                        <th>回访人姓名</th>
                        <th>回访时间</th>
                        <th>回访分类</th>
                        <th>回访结果</th>
                        <th>回访方式</th>
                    </tr>
                    <c:forEach items="${telvisitList}" var="t">
                        <tr>
                            <td>${t.tname}</td>
                            <td>${t.ttime}</td>
                            <td>${t.tclass}</td>
                            <td>${t.tresult}</td>
                            <td>${t.tway}</td>
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
