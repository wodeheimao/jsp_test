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
        .table {
            margin-top: 10px;
        }

        .table th, .table td {
            text-align: center;
            vertical-align: middle !important;
        }
        #form1{
            margin-top: 10px;
        }
    </style>
    <script>
        function pageOver(p) {
            window.location.href="${pageContext.request.contextPath}/addrbook?page="+ p;
        }

        function pagePreOrNext(n) {
            let page = parseInt(${pageResult.page}) + n;
            if(page <= 0 ){
                page = 1;
            }else if(page >= ${pageResult.totalPages}){
                page = ${pageResult.totalPages};
            }
            window.location.href="${pageContext.request.contextPath}/addrbook?page="+page;
        }
    </script>
    <title>学生列表</title>

</head>

<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                联系人列表信息
            </small>
        </h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h4>联系人列表</h4>
                </div>
            </div>
        </div>

        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>住址</th>
            </tr>
            <c:forEach items="${pageResult.list}" var="addrbook">
                <tr>
                    <td>${addrbook.aid}</td>
                    <td>${addrbook.aname}</td>
                    <td>${addrbook.sex}</td>
                    <td>${addrbook.phone}</td>
                    <td>${addrbook.addr}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="javascript:void(0)" onclick="pageOver(1)" aria-label="Previous">
                                    <span aria-hidden="true">首页</span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)" onclick="pagePreOrNext(-1)" aria-label="Previous">
                                    <span aria-hidden="true">上一页</span>
                                </a>
                            </li>
                            <c:forEach begin="1" end="${pageResult.totalPages}" var="p">
                                <li class="${p == pageResult.page ? 'active' : ''}">
                                    <a href="javascript:void(0)" onclick="pageOver('${p}')">${p}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="javascript:void(0)" onclick="pagePreOrNext(+1)" aria-label="Next">
                                    <span aria-hidden="true">下一页&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </td>
            </tr>
        </table>
        <div class="panel-footer text-right">
            一共有<label style="color:red">${pageResult.totalCount}</label>数据 泽林教育2000-2019.
        </div>
    </div>
</div>
</body>
</html>