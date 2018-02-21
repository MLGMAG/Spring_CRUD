<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Users</title>

    <#include "templates/head.ftl">

</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Users
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Users</h2>

<div class="container-fluid row">

    <div class="col-md-11"></div>

    <div class="col-md-1">
        <a href="/user/add" class="btn btn-success">Add</a>
    </div>

</div>

<br>
<table class="table table-bordered table-hover">
    <thead>
    <tr class="active">
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <#list users as user>
		<tbody>
        <tr>
            <td class="data">${user.firstName}</td>
            <td class="data">${user.lastName}</td>
            <td class="data">${user.email}</td>
            <td>
                <a href="/user/${user.id}" class="btn btn-info">VIEW</a>
                &nbsp
                <a href="/user/delete/${user.id}" class="btn btn-danger">DELETE</a>
                &nbsp
                <a href="/user/update/${user.id}" class="btn btn-primary">EDIT</a>
            </td>
        </tr>
        </tbody>
    </#list>
</table>

</body>

</html>