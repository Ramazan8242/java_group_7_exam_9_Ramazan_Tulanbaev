<#import "partials/main.ftlh" as main />

<@main.renderWith>
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
                    <th><a href="/addAnswer">${subject.events}</a></th>
                    <th>${subject.localDate.now()}</th>
                    <th><a href="/profile">${subject.user.username}</a></th>
                    <th><a href="/addAnswer">ответить</a></th>
                </tr>
            </#list>
        </#if>
    </table>
    <#if subj??>
        <a href="/?page=${subj.pageNumber-1}&size=2" style="margin-right: 1200px"><==</a>
    </#if>
    <#if subj??>
        <a href="/?page=${subj.pageNumber+1}&size=2">==></a>
    </#if>
</@main.renderWith>