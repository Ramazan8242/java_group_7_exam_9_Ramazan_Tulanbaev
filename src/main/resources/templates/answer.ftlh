<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <div style="text-align: center">
        <h5  style="color: black; padding-left: 20px">${subject.events} -> ${subject.user.username} -> ${subject.localDate}</h5>
    </div>
    <#if answers??>
        <#list answers as answer>
            <table border="1" width="100%" cellpadding="5">
                <th>${answer.text}</th>
                <th>${answer.user.username}</th>
                <th>${answer.localDate}</th>
            </table>
        </#list>
    </#if>

    <form action="/addAnswer" method="post">
        <label><input type="text" name="text" ></label>
        <button type="submit">Submit</button>
    </form>
</@main.renderWith>