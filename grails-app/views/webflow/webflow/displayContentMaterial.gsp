<%@ page import="seed.ContentMaterial" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'contentMaterial.label', default: 'ContentMaterial')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-contentMaterial" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-contentMaterial" class="content scaffold-show" role="main">

    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form action="contentMaterial" method="post" >

        <ol class="property-list contentMaterial">

            <g:if test="${contentMaterialInstance?.content}">
                <li class="fieldcontain">
                    <span id="content-label" class="property-label"><g:message code="contentMaterialInstance.content.label" default="Content" /></span>

                    <span class="property-value" aria-labelledby="content-label"><g:fieldValue bean="${contentMaterialInstance}" field="content"/></span>

                </li>
            </g:if>

            <g:if test="${contentMaterialInstance?.questionsAndAnswers}">
                <li class="fieldcontain">
                    <span id="questionsAndAnswers-label" class="property-label"><g:message code="contentMaterialInstance.questionsAndAnswers.label" default="Questions And Answers" /></span>

                    <g:each in="${contentMaterialInstance.questionsAndAnswers}" var="q">
                        <span class="property-value" aria-labelledby="questionsAndAnswers-label"><g:link controller="questionAndAnswer" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></span>
                    </g:each>

                </li>
            </g:if>

        </ol>
        <fieldset class="buttons">
            <g:submitButton name="back" value="${message(code: 'default.button.back.label', default: 'Back')}"></g:submitButton>
            <g:submitButton name="submit" value="${message(code: 'default.button.next.label', default: 'Next')}"></g:submitButton>
            <span class="alignRight"><g:submitButton class="save" name="save" value="${message(code: 'default.button.save.label', default: 'Save')}"></g:submitButton></span>

        </fieldset>
    </g:form>
</div>
</body>
</html>