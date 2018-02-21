<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Add Manufacturer</title>

    <#include "templates/head.ftl">

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Add Manufacturer
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Add Manufacturer</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form name="manufacturer" role="form" action="/manufacturer/add" method="post">

                        <fieldset>

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input class="form-control" type="text" name="name" id="name" placeholder="Name">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Add Manufacturer">

                        </fieldset>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>