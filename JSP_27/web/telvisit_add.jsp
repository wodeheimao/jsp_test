<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="bs.jsp"%>
<html>
<head>
    <meta charset="UTF-8">

    <title>添加回访记录</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                添加回访
            </small>
        </h3>
    </div>

    <div class="panel panel-success">
        <div class="panel-heading">
            回访记录
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/company?cmd=add">
                <div class="form-group">
                    <input type="hidden" name="cno" value="${param.cno}">
                    <label class="col-md-2 control-label">回访人姓名</label>
                    <div class="col-md-3">
                        <input class="form-control" name="tname">
                    </div>
                    <label class="col-md-2 control-label">回访时间</label>
                    <div class="col-md-3">
                        <input type="date" class="form-control" id="ttime" name="ttime">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">回访类型</label>
                    <div class="col-md-3">
                        <select class="form-control" name="tclass">
                            <option value="">请选择</option>
                            <option value="售后回访">售后回访</option>
                            <option value="销售意向回访">销售意向回访</option>
                            <option value="满意度回访">满意度回访</option>
                        </select>
                    </div>
                    <label class="col-md-2 control-label">回访方式</label>
                    <div class="col-md-3">
                        <select class="form-control" name="tway">
                            <option value="">请选择</option>
                            <option value="电话回访">电话回访</option>
                            <option value="会议回访">会议回访</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">回访结果</label>
                    <div class="col-md-8">
                        <textarea name="tresult" id="" cols="100" rows="10"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-3 col-md-4">
                        <a href="${pageContext.request.contextPath}/company" class="btn btn-default">取消</a>
                    </div>
                    <div class="col-md-3">
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
