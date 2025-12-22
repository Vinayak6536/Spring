<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zomato Result</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <a class="nav-link" href="addZomato.jsp">Add Restaurant</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="Search.jsp">Search</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- CONTENT -->
<div class="container mt-5">

    <div class="alert alert-success text-center">
        <h4>Restaurant Added Successfully ✅</h4>
    </div>

    <div class="card shadow">
        <div class="card-header bg-success text-white">
            <h5 class="mb-0">Restaurant Details</h5>
        </div>

        <div class="card-body">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>Restaurant Name</th>
                    <td>${zomatoDto.restaurantName}</td>
                </tr>
                <tr>
                    <th>Owner Name</th>
                    <td>${zomatoDto.ownerName}</td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td>${zomatoDto.location}</td>
                </tr>
                <tr>
                    <th>Rating</th>
                    <td>${zomatoDto.rating}</td>
                </tr>
                <tr>
                    <th>Type</th>
                    <td>${zomatoDto.type}</td>
                </tr>
                <tr>
                    <th>Cost for Two</th>
                    <td>₹ ${zomatoDto.costForTwo}</td>
                </tr>
                <tr>
                    <th>Contact Number</th>
                    <td>${zomatoDto.contactNo}</td>
                </tr>
            </table>

            <div class="text-center mt-3">
                <a href="addZomato.jsp" class="btn btn-primary">Add Another</a>
                <a href="index.jsp" class="btn btn-secondary">Home</a>
            </div>
        </div>
    </div>

</div>

</body>
</html>
