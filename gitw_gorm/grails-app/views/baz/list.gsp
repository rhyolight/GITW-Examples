

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'baz.label', default:'Baz')}" />
        <title>${entityName} List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="finder">${entityName} Finder</g:link></span>
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
                        
                   	        <g:sortableColumn property="id" title="${message(code:'baz.id.label', default:'Id')}" />
                        
                   	        <g:sortableColumn property="favoriteColor" title="${message(code:'baz.favoriteColor.label', default:'Favorite Color')}" />
                        
                   	        <g:sortableColumn property="location" title="${message(code:'baz.location.label', default:'Location')}" />
                        
                   	        <g:sortableColumn property="name" title="${message(code:'baz.name.label', default:'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bazInstanceList}" status="i" var="bazInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${bazInstance.id}">${fieldValue(bean:bazInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:bazInstance, field:'favoriteColor')}</td>
                        
                            <td>${fieldValue(bean:bazInstance, field:'location')}</td>
                        
                            <td>${fieldValue(bean:bazInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${bazInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
