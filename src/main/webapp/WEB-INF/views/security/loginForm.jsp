<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
</head>

<body>
    <!-- Menu -->
    <%@ include file="/WEB-INF/views/commons/header.jsp" %>

    <div class="container row">
        <div class="col-md-6 mx-auto">
            <% 
            String fail = request.getParameter("fail");
            %>
            
            <% if ("true".equals(fail)) { %>            
            <div><font color="red"> Login Fail ! </font></div>
            <% } %>
        <form class="form-signin" method="post" action="/login">
            <h2 class="form-signin-heading">We Made Please sign in</h2>
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required=""
                    autofocus="" value="test_01">
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                    required="" value="1234">
            </p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
        </div>
    </div>
</body>

</html>