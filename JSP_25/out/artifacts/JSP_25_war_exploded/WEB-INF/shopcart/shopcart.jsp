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
            window.location.href = "${pageContext.request.contextPath}/shopcart?cmd=cartlist&page=" + p;
            // $("#page").val(p);
            // $("#form1").submit();
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
            window.location.href = "${pageContext.request.contextPath}/shopcart?cmd=cartlist&page=" + page;
            // $("#page").val(page);
            // $("#form1").submit();
        }
    </script>
    <title>购物车</title>

</head>

<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                购物车
            </small>
        </h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <h4>购物车</h4>
                </div>
                <div class="col-md-2">
                    <h4>总数：${maps.snums}</h4>
                </div>
                <div class="col-md-2">
                    <h4>总结：${maps.sprice}</h4>
                </div>
                <div class="col-md-1">
                    <a href="${pageContext.request.contextPath}/shopcart?cmd=delete" class="btn btn-primary">清空</a>
                </div>
                <div class="col-md-1">
                    <a href="${pageContext.request.contextPath}/book" class="btn btn-primary">购买</a>
                </div>
            </div>
        </div>

        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>编号</th>
                <th>商品名</th>
                <th>数量</th>
                <th>总价</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageResult.list}" var="shopcart">
                <tr>
                    <td>${shopcart.sid}</td>
                    <td>${shopcart.gname}</td>
                    <td>${shopcart.goodnums}</td>
                    <td>${shopcart.goodsprice}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/shopcart?cmd=deleteone&sid=${shopcart.sid}&nums=${shopcart.goodnums}" class="btn btn-success">减少一本</a>
                        <a href="${pageContext.request.contextPath}/shopcart?cmd=delete&sid=${shopcart.sid}" class="btn btn-success">清除全部</a>
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