<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>Текст</th>
            <th>Пользователь</th>
            <th>Событие</th>
<#--            <th>Ответ</th>-->
        </tr>
        <#if answers??>
            <#list answers as answer>
                <tr>
                    <th>${answer.text}</th>
                    <th>${answer.user.username}</th>
                    <th>${answer.subject.events}</th>
<#--                    <th>ответить</th>-->
                </tr>
            </#list>
        </#if>
    </table>
    <#if answer??>
        <a href="/?page=${answer.pageNumber-1}&size=2" style="margin-right: 1200px"><==</a>
    </#if>
    <#if answer??>
        <a href="/?page=${answer.pageNumber+1}&size=2">==></a>
    </#if>
</@main.renderWith>