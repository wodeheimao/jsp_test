<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/bs.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>客户资料</title>
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
        function addVisit() {
            var check = document.getElementsByClassName("check_cno");
            var cno = "";
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    cno = check[i].value;
                    break;
                }
            }
            if(cno ==""){
                alert("请勾选")
            }else{
                <%--window.location.href="<%=basePath%>"+"telvisit_add.jsp?cno="+cno;--%>
                window.location.href = "${pageContext.request.contextPath}/telvisit_add.jsp?cno=" + cno;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>客户资料列表</h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
        </div>
        <div class="panel-body">
            <div class="row">
                <!--id与上面标签里面的tab一致-->
                <div id="tab-item1" class="tab-item">
                    <form method="post" id="form1" action="${pageContext.request.contextPath}/company?cmd=search"
                          class="form-inline">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-2">
                                <a href="javascript:void(0)" onclick="addVisit()" class="btn-default btn">添加回访记录</a>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label">公司名</label>
                                <input type="text" name="cname" class="form-control">
                            </div>
                            <div class="col-md-3">
                                <label class="control-label">法人姓名</label>
                                <input type="text" name="fname"  class="form-control">
                            </div>

                            <div class="col-md-1">
                                <input type="submit" class="btn btn-primary" value="查询">
                            </div>
                            <div class="col-md-1">
                                <input type="reset" class="btn btn-primary" value="清空">
                            </div>
                            <%--<div class="col-md-1">--%>
                            <%--<a class="btn btn-success" href="javascript:void(0)" onclick="addVisit()" >添加</a>--%>
                            <%--</div>--%>
                        </div>
                    </form>

                    <table class="table table-bordered table-hover table-striped">
                        <tr>
                            <th>选择</th>
                            <th>公司名称</th>
                            <th>法人名称</th>
                            <th>联系电话</th>
                            <th>公司简介</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${companyinfoList}" var="c">
                            <tr>
                                <td><input type="radio" name="cno" class="check_cno" value="${c.cno}"></td>
                                <td>${c.cname}</td>
                                <td>${c.fname}</td>
                                <td>${c.fphone}</td>
                                <td>${c.cprofile}</td>
                                <td><a href="${pageContext.request.contextPath}/company?cmd=visitlist&cno=${c.cno}"
                                       class="btn btn-success">查看所有回访</a></td>
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
