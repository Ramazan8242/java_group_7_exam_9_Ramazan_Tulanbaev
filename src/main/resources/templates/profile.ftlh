<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??><p>${(dto.username)!'-- missing --'} - ${(dto.email)!'-- email missing --'}</p><#else><h1>Пользователь не найден!</h1></#if>
    <div class="bottom-box"><a href="/">На главную страницу</a></div>
</@main.renderWith>