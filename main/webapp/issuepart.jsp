<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>发布兼职信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/PartServlet?action=issuee" method="post">
    <div class="form-group">
        <label >请输入兼职名称</label>
        <input type="text" class="form-control"  name="partname">
    </div>
    <div class="form-group">
        <label >请输入兼职信息</label>
        <input type="text" class="form-control"  name="message">
    </div>
    <button type="submit" class="btn btn-primary">添加</button>
</form>
</body>
</html>
