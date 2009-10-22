

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'foo.label', default:'Foo')}" />
        <title>Create ${entityName}</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">${entityName} List</g:link></span>
        </div>
        <div class="body">
            <h1>Create ${entityName}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${fooInstance}">
            <div class="errors">
                <g:renderErrors bean="${fooInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="color">
                                      <g:message code="foo.color.label" default="Color" />
                                    </label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooInstance,field:'color','errors')}">
                                    <input type="text" id="color" name="color" value="${fieldValue(bean:fooInstance,field:'color')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">
                                      <g:message code="foo.name.label" default="Name" />
                                    </label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:fooInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
