<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Confirm Log Out?</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
</head>

<body>
    <!-- Menu -->
    <%@ include file="/WEB-INF/views/commons/header.jsp" %>

    <div class="container row">
        <div class="col-md-6 mx-auto">
        <form class="form-signin" method="post" action="/logout">
            <h2 class="form-signin-heading">Are you sure you want to log out?</h2>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>
        </form>
        </div>
    </div>

</body>

</html>