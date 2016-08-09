<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <title>Title</title>
</head>
<body>
<div class="leftnav">
    <div class="list-group">
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation"><a href="${ctx}/index.html" class="list-group-item">首页</a></li>
            <li role="presentation"><a href="${ctx}/editWeibo.html" class="list-group-item">编辑微博内容</a></li>
            <li role="presentation"><a href="${ctx}/sina/interface/userInfo.html" class="list-group-item">用户信息</a></li>
            <li role="presentation"><a href="${ctx}/sina/interface/userFans.html" class="list-group-item">粉丝信息</a></li>
        </ul>
    </div>
</div>
</body>
</html>
