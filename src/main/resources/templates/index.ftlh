<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>
    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>Событие</th>
            <th>Дата</th>
            <th>Пользователь</th>
        </tr>
        <#if subjects??>
            <#list subjects as subject>
                <tr>
                    <th>${subject.events}</th>
                    <th>${subject.localDate}</th>
                    <th>${subject.user.username}</th>
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