<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
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
</body>
</html>