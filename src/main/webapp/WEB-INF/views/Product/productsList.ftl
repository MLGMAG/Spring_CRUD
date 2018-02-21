<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Products</title>

    <#include "templates/head.ftl">

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Products
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Products</h2>

<div class="container-fluid row">

    <div class="col-md-11"></div>

    <div class="col-md-1">
        <a href="/product/add" class="btn btn-success">Add</a>
    </div>

</div>

<br>

<table class="table table-bordered table-hover">
    <thead>
    <tr class="active">
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Action</th>
    </tr>

    </thead>
    <#list products as product>
		<tbody>
        <tr>
            <td class="data">${product.name}</td>
            <td class="data">${product.price}</td>
            <td class="data">${product.manufacturer.name}</td>
            <td>
                <a href="/product/${product.id}" class="btn btn-info">VIEW</a>
                &nbsp
                <a href="/product/delete/${product.id}" class="btn btn-danger">DELETE</a>
                &nbsp
                <a href="/product/update/${product.id}" class="btn btn-primary">EDIT</a>
            </td>
        </tr>
        </tbody>
    </#list>
</table>

</body>
</html>