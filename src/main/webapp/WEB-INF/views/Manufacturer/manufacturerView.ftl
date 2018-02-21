<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Manufacturer</title>

    <meta charset="UTF-8">
    <title>User</title>

    <#include "templates/head.ftl">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Manufacturer
        </div>

        <#include "templates/navbar.ftl">

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/singUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/singIn"><span class="glyphicon glyphicon-log-in"></span> Sing In</a></li>
        </ul>

    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h4 class="text-center title">${manufacturer.name}</h4>
                </div>

                <div class="panel-body">

                    <div class="col-md-6 title">Id:</div>
                    <div class="col-md-6 text-center data">${manufacturer.id}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Name:</div>
                    <div class="col-md-6 text-center data">${manufacturer.name}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Products:</div>
                    <div class="col-md-6 text-center data">
                    <#list products as product>
                        <#if product.name??>${product.name}<#else>None</#if>
                        ${product.name}<br>
                    </#list>
                    </div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <h2 class="text-center"><a href="/manufacturer/list" class="btn btn-success" role="button">Back</a>
                    </h2>
                </div>

            </div>

        </div>

    </div>

</div>
</body>
</html>