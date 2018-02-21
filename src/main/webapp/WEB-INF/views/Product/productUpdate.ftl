<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>

    <#include "templates/head.ftl">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Edit Product
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Edit Product</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" action="/product/update/${product.id}" method="post">
                        <fieldset>

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input class="form-control" type="text" id="name" name="name" value="${product.name}"
                                       placeholder="Name">
                            </div>

                            <div class="form-group">
                                <label for="price">Price</label>
                                <input class="form-control" type="text" id="price" name="price" placeholder="Price">
                            </div>


                            <div class="form-group">
                                <label for="role">Role</label>
                                <br>
                                <#list manufacturers as manufacturer>
                                    <input type="radio" id="role" name="id"
                                           value="${manufacturer.id}">${manufacturer.name}<br>
                                </#list>
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Update Product">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>