<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/UserServlet?action=register" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">账号</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="sno">
        <small id="emailHelp" class="form-text text-muted">请输入要注册的账号等待老师批准</small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">姓名</label>
        <input type="text" class="form-control" aria-describedby="emailHelp" name="name">
        <small  class="form-text text-muted">请输入要注册的姓名</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <button type="submit" class="btn btn-primary">提交</button>
</form>
</body>
</html>
