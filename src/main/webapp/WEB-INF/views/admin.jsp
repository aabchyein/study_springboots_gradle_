<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
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
                <h2>Admin</h2>
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