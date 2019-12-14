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

        #form1 {
            margin-top: 10px;
        }
    </style>
    <script>
        function pageSearch(p) {
            $("#page").val(p);
            $("#form1").submit();
        }
        function pageOver(p) {
            <%--window.location.href = "${pageContext.request.contextPath}/book?page=" + p;--%>
            $("#page").val(p);
            $("#form1").submit();
        }
        $(function () {
            $("#selectId").change(function(){
                var x = $(this).children('option:selected').val();
                pageOver(x);
            });
        });

        function pagePreOrNext(n) {
            var page = parseInt(${pageResult.page}) + n;
            if (page <= 0) {
                page = 1;
            } else if (page >= ${pageResult.totalPages}) {
                page = ${pageResult.totalPages};
            }
            <%--window.location.href = "${pageContext.request.contextPath}/book?page=" + page;--%>
            $("#page").val(page);
            $("#form1").submit();
        }
    </script>
    <title>图书列表</title>

</head>

<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                图书列表信息
            </small>
        </h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h4>图书列表</h4>
                </div>
            </div>
        </div>

        <form method="post" id="form1" action="${pageContext.request.contextPath}/book" class="form-inline">
            <div class="row">
                <div class="col-md-1">
                    <input type="hidden" name="page" id="page" value="${param.page}">
                </div>
                <div class="col-md-3">
                    <label class="control-label">书名</label>
                    <input type="text" name="bname" value="${param.bname}" class="form-control">
                </div>
                <div class="col-md-4">
                    <label class="control-label">出版社</label>
                    <input type="text" name="publisher" value="${param.publisher}" class="form-control">
                </div>

                <div class="col-md-2">
                    <a href="javascript:void(0)" onclick="pageSearch('1')" class="btn btn-primary">查询</a>
                </div>
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/shopcart?cmd=cartlist" class="btn btn-success">查看购物车</a>
                </div>

   <%--             <div class="col-md-1">
                    <a href="${pageContext.request.contextPath}/student?cmd=toadd" class="btn btn-info btn-right">添加</a>
                </div>--%>
            </div>
        </form>


        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>作者</th>
                <th>出版社</th>
                <th>折扣名称</th>
                <th>原价</th>
                <th>拆后价格</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageResult.list}" var="addrbook">
                <tr>
                    <td>${addrbook.bno}</td>
                    <td>${addrbook.bname}</td>
                    <td>${addrbook.author}</td>
                    <td>${addrbook.publisher}</td>
                    <td>${addrbook.discount}</td>
                    <td>${addrbook.yprice}</td>
                    <td>${addrbook.zprice}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/shopcart?cmd=add&bno=${addrbook.bno}">加入购物车</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
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
                            <li>
                                <span>
                                    <select id="selectId">
                                    <c:forEach begin="1" end="${pageResult.totalPages}" var="p">
                                        <option value="${p}" ${p == pageResult.page?'selected':''}>${p}</option>
                                    </c:forEach>
                                </select>
                                </span>
                            </li>
                            <li>
                                <span>第${pageResult.page}页/共${pageResult.totalPages}页</span>
                            </li>
                            <%--<c:forEach begin="1" end="${pageResult.totalPages}" var="p">
                                <li class="${p == pageResult.page ? 'active' : ''}">
                                    <a href="javascript:void(0)" onclick="pageOver('${p}')">${p}</a>
                                </li>
                            </c:forEach>--%>
                            <li>
                                <a href="javascript:void(0)" onclick="pagePreOrNext(+1)" aria-label="Next">
                                    <span aria-hidden="true">下一页</span>
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