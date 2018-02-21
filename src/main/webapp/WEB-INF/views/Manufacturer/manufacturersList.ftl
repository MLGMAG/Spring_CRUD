<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Manufacturers</title>

    <#include "templates/head.ftl">

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Manufacturers
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>
<h2 class="text-center">Manufacturers</h2>

<div class="container-fluid row">

    <div class="col-md-11"></div>

    <div class="col-md-1">
        <a href="/manufacturer/add" class="btn btn-success">Add</a>
    </div>

</div>

<br>
<table class="table table-bordered table-hover">
    <thead>
    <tr class="active">
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
<tbody>
    <#list manufacturers as manufacturer>
    <tr>
        <td class="data">${manufacturer.id}</td>
        <td class="data">${manufacturer.name}</td>
        <td>
            <a href="/manufacturer/${manufacturer.id}" class="btn btn-info">VIEW</a>
            &nbsp
            <a href="/manufacturer/delete/${manufacturer.id}" class="btn btn-danger">DELETE</a>
            &nbsp
            <a href="/manufacturer/update/${manufacturer.id}" class="btn btn-primary">EDIT</a>
        </td>
    </tr>
    </tbody>
    </#list>
</table>

</body>
</html>