<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>多发信息科技</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/global.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/left.jsp"/>
<div class="float:right">
    <button onclick="test();">微博登录授权测试</button>
</div>
</body>
<script>
    function test(){
    location.href="https://api.weibo.com/oauth2/authorize?forcelogin=true&client_id=3420153323&scope=all&redirect_uri=http://www.oncepush.com/sina/interface/accredit/callback.html";
    }
</script>
</html>