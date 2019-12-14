<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/bs.jsp"%>

<html>
<head>
    <title>员工列表</title>
    <style>
        #form1{
            margin-bottom: 10px;
        }
    </style>
    <script>
        function search(v) {
            $(".tab").removeClass("active");
            // this.addClass("active");
            console.log(${pageContext.request.contextPath}+"/emp?cmd=list&did=${d.did}")
            window.location.href=${pageContext.request.contextPath}+"/emp?cmd=list&did=${d.did}";
        }
    </script>
</head>
<body>
<div class="container" style="width: 80%;">
    <div class="page-header">
        <h3>员工列表</h3>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
        </div>
        <div class="panel-body">
            <div class="row">
                <div id="tabs" class="list-group col-md-1 ">
                    <c:forEach items="${depts}" var="d">
                        <button tab="tab-item1" onclick="search('${d.did}')"  class="tab list-group-item">${d.dname}</button>
                    </c:forEach>
                </div>
                <div class="col-md-11 ">
                    <!--id与上面标签里面的tab一致-->
                    <div id="tab-item1" class="tab-item">
                        <form method="post" id="form1" action="${pageContext.request.contextPath}/emp?cmd=search" class="form-inline">
                            <div class="row">
                                <div class="col-md-3">
                                    <label class="control-label">姓名</label>
                                    <input type="text" name="ename" value="${param.ename}" class="form-control">
                                </div>
                                <div class="col-md-3">
                                    <label class="control-label">部门</label>
                                    <input type="text" name="dname" value="${param.dname}" class="form-control">
                                </div>
                                <div class="col-md-4">
                                    <label class="control-label">入职日期</label>
                                    <input type="date" name="sdate" value="${param.sdate}" class="form-control"> -
                                    <input type="date" name="edate" value="${param.edate}" class="form-control">
                                </div>
                                <div class="col-md-1">
                                    <input type="submit" class="btn btn-primary" value="查询">
                                </div>
                                <div class="col-md-1">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}/emp?cmd=toadd">添加</a>
                                </div>
                            </div>
                        </form>

                        <table class="table table-bordered table-hover table-striped">
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>账号</th>
                                <th>联系电话</th>
                                <th>电子邮箱</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${emps}" var="e">
                                <tr>
                                    <td>${e.eid}</td>
                                    <td>${e.ename}</td>
                                    <td>${e.username}</td>
                                    <td>${e.phone}</td>
                                    <td>${e.eamil}</td>
                                    <td>${e.status}</td>
                                    <td>操作</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
