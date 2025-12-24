<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phone Search</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Zomato</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ZomatoForm.jsp">Add Restaurant</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="Search.jsp">Search</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- MAIN CONTENT -->
<div class="container mt-5">

    <!-- SEARCH FORM -->
    <div class="card shadow mb-4">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Search Restaurant</h5>
        </div>

        <div class="card-body">
            <form action="search" method="get" class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Phone Number</label>
                    <input type="number" name="phone" class="form-control" placeholder="Enter phone No" required>
                </div>

                <div class="col-md-6 d-flex align-items-end">
                    <input type="submit" value="Search" class="btn btn-success w-100">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
