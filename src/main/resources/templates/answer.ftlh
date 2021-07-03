<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <div style="text-align: center">
        <h5  style="color: black; padding-left: 20px">${subject.events} -> ${subject.user.username} -> ${subject.localDate}</h5>
    </div>
</@main.renderWith>