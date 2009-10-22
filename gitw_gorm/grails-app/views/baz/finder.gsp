

<html>
    <head>
        <g:javascript src="jquery-1.3.2.js"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'baz.label', default:'Baz')}" />
        <title>${entityName} Finder</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">${entityName} List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ${entityName}</g:link></span>
        </div>
        <div class="body">
            <h1>${entityName} List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div>
                <g:select name="findBy" from="${findableProperties}" 
                          noSelection="['':'-Choose property-']"/>
                <input id="value" name="value" value=""/>
                <button id='submit'>Submit</button>
                <br/><br/>
                
                <div id='result'></div>
                
                <script>
                    $('#submit').click(function() {
                        var findBy = $('#findBy').val();
                        var value = $('#value').val();
                        $.ajax({
                            url: "${createLink(action:'bazFindBy')}",
                            data: "findBy=" + findBy + "&value=" + value,
                            success: function(obj) {
                                $('#result').html(obj)
                            }
                        });
                    });
                </script>
            </div>
        </div>
    </body>
</html>
