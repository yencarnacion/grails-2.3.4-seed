<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <sec:ifNotGranted roles="ROLE_USER">
        <sec:ifAllGranted roles="ROLE_ADMIN">
            <title><g:message code="grailsSeed.admin.welcome" default="Admin Welcome"/></title>
        </sec:ifAllGranted>
    </sec:ifNotGranted>
    <sec:ifAllGranted roles="ROLE_USER">
        <title><g:message code="grailsSeed.user.welcome" default="User Welcome"/></title>
    </sec:ifAllGranted>
</head>
<body>
<ul>
    <li class="controller"><g:link controller="webflow"><g:message code="admin.welcome" default="Content Material Webflow" /></g:link></li>
</ul>
</body>
</html>