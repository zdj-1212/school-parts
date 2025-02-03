<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<head>
    <title>管理注册信息</title>
</head>
<style>
    .a1{
        color: #ffffff;
    }
</style>
<body>

<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<c:forEach items="${userreg}" var="item">
<ul class="list-group list-group-horizontal">
    <li class="list-group-item">${item.sno}</li>
    <li class="list-group-item">${item.name}</li>
    <li class="list-group-item">${item.password}</li>
    <li class="list-group-item"><button type="button"  class="btn btn-outline-primary" >
        <a class="=a1" href="${pageContext.request.contextPath}/UserServlet?action=tongyi&sno=${item.sno}">同意</a></button></li>
    <li class="list-group-item"><button type="button" onclick="jujue(${item.sno})" class="btn btn-danger" >
        <a class="a1" href="${pageContext.request.contextPath}/UserServlet?action=jujue&sno=${item.sno}">拒绝</a></button></li>
</ul>
</c:forEach>
</body>
</html>
