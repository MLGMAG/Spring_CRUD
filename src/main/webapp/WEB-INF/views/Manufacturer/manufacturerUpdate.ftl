<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Manufacturer Update</title>

    <#include "templates/head.ftl">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header navbar-brand">
            Edit Manufacturer
        </div>

        <#include "templates/navbar.ftl">

    </div>
</nav>

<h2 class="text-center">Edit Manufacturer</h2>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form accept-charset="UTF-8" action="/manufacturer/update/${manufacturer.id}" method="post">
                        <fieldset>

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input class="form-control" type="text" id="name" name="name"
                                       value="${manufacturer.name}" placeholder="Name">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Update Manufacturer">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>