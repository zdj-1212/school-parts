<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>评论</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<c:forEach var="item" items="${partcommentList}">
    <ul class="list-group list-group-horizontal">
        <li class="list-group-item">${item.bid}</li>
        <li class="list-group-item">${item.comment}</li>
        <c:if test="${user.flag==1}">
            <li class="list-group-item"><button type="button" class="btn btn-outline-primary" >
                <a class="a1" href="${pageContext.request.contextPath}/PartcommentServlet?action=shanchu&bid=${item.bid}&id=${item.id}">删除该评论</a></button></li>
        </c:if>
    </ul>
</c:forEach>
</body>

</html>
