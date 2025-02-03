<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<style>
    #a1{
        color: #1f18ec;
    }
    #a2{
        color: #1591bb;
    }
    #a3{
        color: #d92180;
    }
</style>
<body>
<jsp:include page="${pageContext.request.contextPath}/UserServlet?action=isautologin"></jsp:include>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">校园兼职平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">首页 <span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${empty user}">
                <li class="nav-item active" >
                    <a class="nav-link" id="a2" href="#">您的身份是游客<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/login.html">登录 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register.jsp">注册 <span class="sr-only">(current)</span></a>
                </li>
            </c:if>
            <c:if test="${!empty user&&user.flag==0}">
                <li class="nav-item active" >
                    <a class="nav-link" id="a1" href="#">欢迎${user.name},您的身份是会员<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=myinfo">我的信息 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=exit">退出登录 <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${empty cookie.snocookie.value}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=autologin">下次自动登录 <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
                <c:if test="${!empty cookie.snocookie.value}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=noautologin">取消下次自动登录 <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
            </c:if>
            <c:if test="${!empty user&&user.flag==1}">
                <li class="nav-item active" >
                    <a class="nav-link" id="a3" href="#">欢迎${user.name},您的身份是管理员<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=myinfo">我的信息 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=adminreg">管理注册信息 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=adminuser">管理会员信息 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/issuepart.jsp">发布兼职信息 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=exit">退出登录 <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${empty cookie.snocookie.value}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=autologin">下次自动登录 <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
                <c:if test="${!empty cookie.snocookie.value}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=noautologin">取消下次自动登录 <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
            </c:if>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/SearchServlet">
            <input class="form-control mr-sm-2" type="search" placeholder="输入关键字" aria-label="Search" name="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
        </form>
    </div>
</nav>
</body>
</html>
