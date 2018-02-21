<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Product</title>

    <#include "templates/head.ftl">

</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Product
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h4 class="text-center title">${product.name}</h4>
                </div>

                <div class="panel-body">

                    <div class="col-md-6 title">Id:</div>
                    <div class="col-md-6 text-center data">${product.id}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Name:</div>
                    <div class="col-md-6 text-center data">${product.name}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Price:</div>
                    <div class="col-md-6 text-center data">${product.price}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Manufacturer:</div>
                    <div class="col-md-6 text-center data">${product.manufacturer.name}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <h2 class="text-center"><a href="/product/list" class="btn btn-success" role="button">Back</a>
                    </h2>
                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>