<#import "partials/main.ftlh" as main />

<@main.renderWith>
            <form action="/addSubject" method="post">
                <label><input type="text" name="events" ></label>

                <button type="submit">Submit</button>
            </form>
</@main.renderWith>