<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>System Error</title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><g:link controller="loginSuccess" action="index" ><g:message code="default.home.label"/></g:link></span>
</div>
<div class="body">
    <h1>System Error</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>

    There was an error, please try again
</div>
</body>
</html>