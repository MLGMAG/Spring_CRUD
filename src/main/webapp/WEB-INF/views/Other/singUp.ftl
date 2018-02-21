<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Sing Up</title>

    <#include "templates/head.ftl">

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Sing Up
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Sing Up</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" action="/singUp" method="post">
                        <fieldset>

                            <div class="form-group">
                                <label for="username">Username</label>
                                <input class="form-control" type="text" id="username" placeholder="Username"
                                       name="username">
                            </div>

                            <div class="form-group">
                                <label for="first_name">First name</label>
                                <input class="form-control" type="text" id="first_name" placeholder="First name"
                                       name="firstName">
                            </div>

                            <div class="form-group">
                                <label for="last_name">Last name</label>
                                <input class="form-control" type="text" id="last_name" placeholder="Last name"
                                       name="lastName">
                            </div>

                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" type="text" id="email" placeholder="E-mail"
                                       name="email">
                            </div>

                            <div class="form-group">
                                <label for="password">Password</label>
                                <input class="form-control" type="password" id="password" placeholder="Password"
                                       name="password">
                            </div>

                            <div class="form-group">
                                <label for="confirmPassword">Password</label>
                                <input class="form-control" type="password" id="confirmPassword"
                                       placeholder="Confirm password"
                                       name="confirmPassword">
                            </div>

                            <input class="btn btn-success btn-block" type="submit" value="Sing Up">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>