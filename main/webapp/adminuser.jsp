<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>管理会员信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<style>
    .a1{
        color: #ffffff;
    }
    .a2{
        color: #006eff;
    }
</style>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<c:forEach items="${adminuserlist}" var="item">
    <ul class="list-group list-group-horizontal">
        <li class="list-group-item">${item.sno}</li>
        <li class="list-group-item">${item.name}</li>
        <li class="list-group-item">${item.password}</li>
        <li class="list-group-item"><button type="button" class="btn btn-outline-primary" >
            <a class="a2" href="${pageContext.request.contextPath}/UserServlet?action=xiangxi&sno=${item.sno}">查看详细信息</a></button></li>
        <li class="list-group-item"><button type="button"  class="btn btn-danger" >
            <a class="a1" href="${pageContext.request.contextPath}/UserServlet?action=shanchu&sno=${item.sno}">删除该用户</a></button></li>
        <c:if test="${item.flag==0}">
            <li class="list-group-item"><button type="button" class="btn btn-danger" >
                <a class="a1" href="${pageContext.request.contextPath}/UserServlet?action=setadmin&sno=${item.sno}">设为管理员</a></button></li>
        </c:if>
        <c:if test="${item.flag==1}">
            <li class="list-group-item"><button type="button" class="btn btn-dark" >
                <a class="a1" href="${pageContext.request.contextPath}/UserServlet?action=setuser&sno=${item.sno}">设为会员</a></button></li>
        </c:if>
    </ul>
</c:forEach>
</body>
<script>

</script>
</html>
