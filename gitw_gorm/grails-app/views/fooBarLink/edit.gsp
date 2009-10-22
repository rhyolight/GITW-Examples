

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'fooBarLink.label', default:'FooBarLink')}" />
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
            <g:hasErrors bean="${fooBarLinkInstance}">
            <div class="errors">
                <g:renderErrors bean="${fooBarLinkInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${fooBarLinkInstance?.id}" />
                <input type="hidden" name="version" value="${fooBarLinkInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="bar">
                                    <g:message code="fooBarLink.bar.label" default="Bar" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooBarLinkInstance,field:'bar','errors')}">
                                    <g:select optionKey="id" from="${Bar.list()}" name="bar.id" value="${fooBarLinkInstance?.bar?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated">
                                    <g:message code="fooBarLink.dateCreated.label" default="Date Created" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooBarLinkInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${fooBarLinkInstance?.dateCreated}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="foo">
                                    <g:message code="fooBarLink.foo.label" default="Foo" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooBarLinkInstance,field:'foo','errors')}">
                                    <g:select optionKey="id" from="${Foo.list()}" name="foo.id" value="${fooBarLinkInstance?.foo?.id}" ></g:select>
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
