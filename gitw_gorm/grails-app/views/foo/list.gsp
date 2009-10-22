

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'foo.label', default:'Foo')}" />
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
                        
                   	        <g:sortableColumn property="id" title="${message(code:'foo.id.label', default:'Id')}" />
                        
                   	        <g:sortableColumn property="name" title="${message(code:'foo.name.label', default:'Name')}" />
                        
                   	        <g:sortableColumn property="bars" title="${message(code:'foo.bars.label', default:'Bars')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fooInstanceList}" status="i" var="fooInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${fooInstance.id}">${fieldValue(bean:fooInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:fooInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:fooInstance, field:'bars')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fooInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
