<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="bs.jsp"%>
<html>
<head>
    <meta charset="UTF-8">

    <title>发帖</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>
            <small>
                修改帖子
            </small>
        </h3>
    </div>

    <div class="panel panel-success">
        <div class="panel-heading">
            贴子信息
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/tie?cmd=update">
                <input type="hidden" name="tid" value="${tie.tid}">
                <div class="form-group">
                    <label class="col-md-2 control-label">标题</label>
                    <div class="col-md-9">
                        <input class="form-control" name="title"  value="${tie.title}">
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">发表人</label>
                    <div class="col-md-2">
                        <input type="text" class="form-control" disabled="disabled" name="tname" value="${tie.tname}">
                    </div>
                    <label class="col-md-1 control-label">发表时间</label>
                    <div class="col-md-2">
                        <input type="text" class="form-control" disabled="disabled" name="pubdate" value="${tie.pubdate}">
                    </div>
                    <label class="col-md-2 control-label">选择所属板块</label>
                    <div class="col-md-2">
                        <select class="form-control" name="pid">
                            <c:forEach items="${bankuaiList}" var="b">
                                <option value="${b.pid}" ${b.pid == tie.pid?'selected':''}>${b.pname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">内容</label>
                    <div class="col-md-10">
                        <textarea name="msgcontent" id="" cols="100" rows="20" >${tie.msgcontent}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-3 col-md-4">
                        <a href="${pageContext.request.contextPath}/tie" class="btn btn-default">取消</a>
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
