<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>我的信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<div>
    <form action="${pageContext.request.contextPath}/UserServlet?action=update" method="post">
        <div class="form-group">
            <label >账号</label>
            <input type="text" class="form-control" value="${user.sno}"   name="sno" readonly>
        </div>
        <div class="form-group">
            <label >姓名</label>
            <input type="text" class="form-control" value="${user.name}"  name="name">
        </div>
        <div class="form-group">
            <label >密码</label>
            <input type="text" class="form-control" value="${user.password}"  name="password">
        </div>
        <div class="form-group">
            <label >我的兼职申请</label>
            <input type="text" class="form-control" placeholder="${partname}"  name="partid" readonly>

        </div>
        <div class="form-group">
            <label >我的身份</label>
            <input type="text" class="form-control" <c:if test="${user.flag==1}">placeholder="管理员" </c:if>
                   <c:if test="${user.flag==0}">placeholder="会员" </c:if> name="flag" readonly>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="jianzhi">
            <label class="form-check-label" for="exampleCheck1">清除兼职信息</label>
        </div>
        <button type="submit" class="btn btn-primary">提交修改</button>
    </form>
</div>
</body>
</html>
