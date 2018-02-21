<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Edit User</title>

    <#include "templates/head.ftl">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Edit User
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Edit User</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" action="/user/update/${user.id}" method="post">
                        <fieldset>

                            <div class="form-group">
                                <label for="username">Username</label>
                                <input class="form-control" type="text" id="username" name="username"
                                       value="${user.username}" placeholder="Username">
                            </div>

                            <div class="form-group">
                                <label for="first_name">First name</label>
                                <input class="form-control" type="text" id="first_name" name="firstName"
                                       value="${user.firstName}" placeholder="Name">
                            </div>

                            <div class="form-group">
                                <label for="last_name">Last name</label>
                                <input class="form-control" type="text" id="last_name" name="lastName"
                                       value="${user.lastName}" placeholder="Last name">
                            </div>

                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" type="text" id="email" name="email"
                                       value="${user.email}" placeholder="E-mail">
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

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Update User">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>