<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap 5 Template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
</head>

<body>

    <!-- Menu -->
    <%@ include file="/WEB-INF/views/commons/header.jsp" %>

    <!-- Main Content -->
    <%
        String name = (String)request.getAttribute("name");
    %>
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-8">
                <h2>Search</h2>
                <div class="input-group mb-3">
                    <input type="text" value="<%= name %>" class="form-control" placeholder="Search..." id="keydownEnter">
                    <button class="btn btn-primary" type="button" onclick="carTableBody()">Go</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-4 mt-4">
        <div class="container">
            <p>&copy; 2023 Your Website. All Rights Reserved.</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>