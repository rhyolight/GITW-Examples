

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'bar.label', default:'Bar')}" />
        <title>Edit ${entityName}</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">${entityName} List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ${entityName}</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ${entityName}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${barInstance}">
            <div class="errors">
                <g:renderErrors bean="${barInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${barInstance?.id}" />
                <input type="hidden" name="version" value="${barInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="foo">
                                    <g:message code="bar.foo.label" default="Foo" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:barInstance,field:'foo','errors')}">
                                    <g:select optionKey="id" from="${Foo.list()}" name="foo.id" value="${barInstance?.foo?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="image">
                                    <g:message code="bar.image.label" default="Image" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:barInstance,field:'image','errors')}">
                                    <input type="text" id="image" name="image" value="${fieldValue(bean:barInstance,field:'image')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name">
                                    <g:message code="bar.name.label" default="Name" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:barInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:barInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
