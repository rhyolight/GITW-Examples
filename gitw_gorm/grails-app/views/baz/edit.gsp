

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'baz.label', default:'Baz')}" />
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
            <g:hasErrors bean="${bazInstance}">
            <div class="errors">
                <g:renderErrors bean="${bazInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${bazInstance?.id}" />
                <input type="hidden" name="version" value="${bazInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteColor">
                                    <g:message code="baz.favoriteColor.label" default="Favorite Color" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bazInstance,field:'favoriteColor','errors')}">
                                    <input type="text" id="favoriteColor" name="favoriteColor" value="${fieldValue(bean:bazInstance,field:'favoriteColor')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="location">
                                    <g:message code="baz.location.label" default="Location" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bazInstance,field:'location','errors')}">
                                    <input type="text" id="location" name="location" value="${fieldValue(bean:bazInstance,field:'location')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name">
                                    <g:message code="baz.name.label" default="Name" />
                                  </label>

                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bazInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:bazInstance,field:'name')}"/>
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
