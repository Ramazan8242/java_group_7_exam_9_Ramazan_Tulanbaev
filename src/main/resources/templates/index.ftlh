<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h1 style="text-align: center">Темы</h1><br/><br/>
    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>Событие</th>
            <th>Дата</th>
            <th>Пользователь</th>
            <th>Ответ</th>
        </tr>
        <#if subjects??>
            <#list subjects as subject>
                <tr>
                    <th>${subject.events}</th>
                    <th>${subject.localDate.now()}</th>
                    <th><a href="/profile">${subject.user.username}</a></th>
                    <th><form action="/addAnswer"><input name="id" value="${subject.id}" hidden><button type="submit"> ответить </button></form></th>
                </tr>
            </#list>
        </#if>
    </table>
    <#if subj??><a href="/?page=${subj.pageNumber-1}&size=2" style="margin-right: 1200px"><==</a></#if>
    <#if subj??><a href="/?page=${subj.pageNumber+1}&size=2">==></a></#if>
</@main.renderWith>