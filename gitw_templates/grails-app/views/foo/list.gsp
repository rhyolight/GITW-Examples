

<html>
    <head>
        <g:javascript src="jquery-1.3.2.js"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'foo.label', default:'Foo')}" />
        <title>${entityName} List</title>
        <script>
            $(function() {
                $('.fooRow').hover(function() {
                    var id = this.id.split('_')[1];
                    $.ajax({
                        url: "${createLink(action:'detailOnly')}",
                        data: "id=" + id,
                        success: function(obj) {
                            $('#detail').html(obj)
                        }
                    });
                    
                });
            });
        </script>
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
                        
                   	        <g:sortableColumn property="color" title="${message(code:'foo.color.label', default:'Color')}" />
                        
                   	        <g:sortableColumn property="name" title="${message(code:'foo.name.label', default:'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fooInstanceList}" status="i" var="fooInstance">
                        <tr id="foo_${fooInstance.id}" class="fooRow ${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>
                                <g:link action="show" id="${fooInstance.id}">                   
                                    ${fieldValue(bean:fooInstance, field:'id')}
                                </g:link>
                            </td>
                        
                            <td>${fieldValue(bean:fooInstance, field:'color')}</td>
                        
                            <td>${fieldValue(bean:fooInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fooInstanceTotal}" />
            </div>
            <br/><br/>
            <div id='detail'></div>
        </div>
    </body>
</html>
