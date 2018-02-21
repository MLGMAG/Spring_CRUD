<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Add User</title>

    <#include "templates/head.ftl">

</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Add User
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Add User</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" action="/user/add" method="post">
                        <fieldset>

                            <div class="form-group">
                                <label for="username">Username</label>
                                <input class="form-control" type="text" id="username" name="username"
                                       placeholder="Username">
                            </div>

                            <div class="form-group">
                                <label for="first_name">First name</label>
                                <input class="form-control" type="text" id="first_name" name="firstName"
                                       placeholder="First name">
                            </div>

                            <div class="form-group">
                                <label for="last_name">Last name</label>
                                <input class="form-control" type="text" id="last_name" name="lastName"
                                       placeholder="Last name">
                            </div>

                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" type="text" id="email" name="email" placeholder="E-mail">
                            </div>

                            <div class="form-group">
                                <label for="password">Password</label>
                                <input class="form-control" type="password" id="password" name="password"
                                       placeholder="Password">
                            </div>

                            <div class="form-group">
                                <label for="role">Role</label>
                                <br>
                                <#list roles as role>
                                    <input type="radio" id="role" name="role" value="${role}">${role}<br>
                                </#list>
                            </div>

                            <input class="btn btn-success btn-block" type="submit" value="Add User">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>