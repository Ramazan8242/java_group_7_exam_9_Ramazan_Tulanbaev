<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dtos??><p>${(dtos.username)!'-- missing --'}}</p></#if>
    <#if subject??>
        <#list subject as subjects>
            <form action="/addSubject" method="post">
                <label><input type="text" value="${subjects.events}"></label>
                <button type="submit">Submit</button>
            </form>
        </#list>
    </#if>
</@main.renderWith>