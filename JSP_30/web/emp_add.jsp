<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        .panel {
            width: 60%;
            margin: 0 auto;
        }
    </style>
    <title>添加学生</title>
    <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="bootstrap-3.3.7/js/jquery.min.js"></script>
    <script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                添加员工
            </small>
        </h3>
    </div>

    <div class="panel panel-success">
        <div class="panel-heading">
            员工信息
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="post" action="emp1?cmd=add">
                <div class="form-group">
                    <label class="col-sm-2 control-label">编号</label>
                    <div class="col-sm-8">
                        <input class="form-control" name="eid">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-8">
                        <input class="form-control" name="ename">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-8">
                        <input class="form-control" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-8">
                        <input class="form-control" name="phone">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电子邮箱</label>
                    <div class="col-sm-8">
                        <input class="form-control" name="eamil">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">状态</label>
                    <div class="col-sm-8">
                        <div class="radio">
                            <label>
                                <input type="radio" name="status" value="启用" checked>启用
                            </label>
                            <label>
                                <input type="radio" name="status" value="启用">不启用
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="did">
                            <c:forEach items="${depts}" var="d">
                                <option value="${d.did}">${d.dname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-4">
                        <a href="emp1?cmd=list" class="btn btn-default">取消</a>
                    </div>
                    <div class="col-sm-3">
                        <button type="submit" class="btn btn-success">保存</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="panel-footer text-right">
            泽林教育2000-2019.
        </div>
    </div>
</div>
</body>
</html>
