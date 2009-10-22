

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'fooBarLink.label', default:'FooBarLink')}" />
        <title>${entityName} List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ${entityName}</g:link></span>
        </div>
        <div class="body">
            <h1>${entityName} List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="${message(code:'fooBarLink.id.label', default:'Id')}" />
                        
                   	        <th><g:message code="fooBarLink.bar.label" default="Bar" /></th>
                   	    
                   	        <g:sortableColumn property="dateCreated" title="${message(code:'fooBarLink.dateCreated.label', default:'Date Created')}" />
                        
                   	        <th><g:message code="fooBarLink.foo.label" default="Foo" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fooBarLinkInstanceList}" status="i" var="fooBarLinkInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${fooBarLinkInstance.id}">${fieldValue(bean:fooBarLinkInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:fooBarLinkInstance, field:'bar')}</td>
                        
                            <td>${fieldValue(bean:fooBarLinkInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:fooBarLinkInstance, field:'foo')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fooBarLinkInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
