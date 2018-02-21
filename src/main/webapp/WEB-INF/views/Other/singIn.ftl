<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sing In</title>

    <#include "templates/head.ftl" >

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Sing In
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>


<h2 class="text-center">Sing In</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form">
                        <fieldset>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" id="email" placeholder="E-mail" type="text">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input class="form-control" id="password" placeholder="Password" type="password">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Sing In">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>