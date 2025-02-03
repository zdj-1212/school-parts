<%--
  Created by IntelliJ IDEA.
  User: zdj
  Date: 2023/12/22
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找结果</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<c:forEach var="item" items="${searchpartsList}">
    <ul class="list-group list-group-horizontal">
        <li class="list-group-item">${item.id}</li>
        <li class="list-group-item">${item.partname}</li>
        <li class="list-group-item">${item.message}</li>
        <c:if test="${!empty user}">
            <li class="list-group-item"><button type="button" onclick="fabiao(${item.id})" class="btn btn-outline-primary" >发布评论</button></li>
            <li class="list-group-item"><button type="button" onclick="shenqing(${item.id})" class="btn btn-outline-primary">申请该兼职</button></li>
        </c:if>
        <li class="list-group-item chakan"><button type="button" onclick="chakan(${item.id})" class="btn btn-outline-primary">查看该评论</button></li>
    </ul>
</c:forEach>
</body>
<script>
    function fabiao(id) {
        let pro = prompt("请输入你的评论：");
        window.location.href="${pageContext.request.contextPath}/PartcommentServlet?action=pro1&pro="+pro+"&id="+id;
    }
    function shenqing(id) {
        window.location.href="${pageContext.request.contextPath}/UserServlet?action=shenqing&id="+id;
    }
    function chakan(id) {
        window.location.href="${pageContext.request.contextPath}/PartcommentServlet?action=pro2&id="+id;
    }
</script>
</html>
