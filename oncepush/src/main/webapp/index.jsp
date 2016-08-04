<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" pageEncoding="utf-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap test</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
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
    <button onclick="test();">微博登录授权测试</button>
</div>
</body>
<script>
    function test(){
    location.href="https://api.weibo.com/oauth2/authorize?client_id=3420153323&scope=all&redirect_uri=http://www.oncepush.com/sina/interface/accredit/callback.html";
    }
</script>
</html>