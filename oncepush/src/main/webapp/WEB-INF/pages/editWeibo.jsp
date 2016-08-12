<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>多发信息科技</title>
    <link href="${ctx}/static/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/global.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/left.jsp"/>
<div class="content">
    <div align="center">
        <h3>编辑您的微博内容</h3>
        <script id="editor" type="text/plain" style="width:97%;height:700px;"></script>
        <div class="submit-div">
            <div class="place-right">
                <button class="btn btn-primary save-btn">保存</button>
                <button class="btn btn-inverse cancel-btn">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${ctx}/static/plugins/third-party/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/static/plugins/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/static/js/editWeibo.js"></script>