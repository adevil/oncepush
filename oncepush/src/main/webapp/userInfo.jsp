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
<jsp:include page="common/top.jsp"/>
<jsp:include page="common/left.jsp"/>
<div class="float:right">
   <%--<div id="userInfo"></div>--%>
       ${userInfo}
</div>
</body>
</html>
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.min.js"></script>
<script>
    $(function () {
        $("#userInfo").html(syntaxHighlight('${request.userInfo}'));
    });

    function syntaxHighlight(json) {
        if (typeof json != 'string') {
            json = JSON.stringify(json, undefined, 2);
        }
        json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
        return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
            var cls = 'number';
            if (/^"/.test(match)) {
                if (/:$/.test(match)) {
                    cls = 'key';
                } else {
                    cls = 'string';
                }
            } else if (/true|false/.test(match)) {
                cls = 'boolean';
            } else if (/null/.test(match)) {
                cls = 'null';
            }
            return '<span class="' + cls + '">' + match + '</span>';
        });
    }
</script>