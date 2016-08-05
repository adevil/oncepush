<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>多发信息科技</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/global.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/static/plugins/third-party/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0);">
                多发信息技术
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><a href="javascript:void(0);">首页</a></li>
                <li role="presentation"><a href="javascript:void(0);">腾讯微信</a></li>
                <li role="presentation"><a href="javascript:void(0);">新浪微博</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="leftnav">
    <div class="list-group">
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation"><a href="javascript:void(0);" class="list-group-item">首页</a></li>
            <li role="presentation"><a href="javascript:void(0);" class="list-group-item">首页</a></li>
            <li role="presentation"><a href="javascript:void(0);" class="list-group-item">首页</a></li>
        </ul>
    </div>
</div>
<div class="float:right">
    <div>
        <h3>编辑您的微博内容</h3>
        <script id="editor" type="text/plain" style="width:900px;height:500px;"></script>
    </div>
</div>
</body>
<script type="text/javascript">
    var basePath =  '${cxt}';
    var ue = UE.getEditor('editor');
</script>
</html>