<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>User</title>

    <#include "templates/head.ftl">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            User
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h4 class="text-center title">${user.firstName}&nbsp${user.lastName}</h4>
                </div>

                <div class="panel-body">

                    <div class="col-md-6 title">Id:</div>
                    <div class="col-md-6 text-center data">${user.id}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Username:</div>
                    <div class="col-md-6 text-center data">${user.username}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">First Name:</div>
                    <div class="col-md-6 text-center data">${user.firstName}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Last Name:</div>
                    <div class="col-md-6 text-center data">${user.lastName}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Email:</div>
                    <div class="col-md-6 text-center data">${user.email}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Password:</div>
                    <div class="col-md-6 text-center data">${user.password}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>
                    <div class="col-md-6 title">Role:</div>
                    <div class="col-md-6 text-center data">${user.role}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <h2 class="text-center"><a href="/user/list" class="btn btn-success" role="button">Back</a>
                    </h2>
                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>