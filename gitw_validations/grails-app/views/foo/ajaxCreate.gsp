

<html>
    <head>
        <script src="http://www.google.com/jsapi" type="text/javascript"></script> 
        <script type="text/javascript">google.load("jquery", "1.3.2");</script>
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
        <div class="body" style="width:300px">
            <h1>Create ${entityName}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">
                                      <g:message code="foo.name.label" default="Name" />
                                    </label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fooInstance,field:'name','errors')}">
                                    <input type="text" maxlength="16" id="name" name="name" value="${fieldValue(bean:fooInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input id="createButton" class="save" type="submit" value="Create" /></span>
                </div>
                <div id="createResult"></div>
            <script>
                
                $('#createButton').click(function() {
                    var name = $('#name').val();
                    $.ajax({
                        url: "${createLink(action:'createAjax')}",
                        data: "name=" + name,
                        success: function(obj) {
                            $('#createResult').html(obj);
                        }
                    });
                });
            </script>
        </div>
    </body>
</html>
