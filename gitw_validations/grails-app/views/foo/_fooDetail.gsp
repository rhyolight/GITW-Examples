<div class="dialog">
    <table>
        <tbody>

        
            <tr class="prop">
                <td valign="top" class="name">
                   <g:message code="foo.id.label" default="Id" />:
                </td>
                
                <td valign="top" class="value">${fieldValue(bean:fooInstance, field:'id')}</td>
                
            </tr>
        
            <tr class="prop">
                <td valign="top" class="name">
                   <g:message code="foo.name.label" default="Name" />:
                </td>
                
                <td valign="top" class="value">${fieldValue(bean:fooInstance, field:'name')}</td>
                
            </tr>
        
        </tbody>
    </table>
</div>