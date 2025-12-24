<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Details</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Zomato</a>
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
</nav>

<div class="container mt-5">

    <div class="card shadow p-4">
        <h3 class="text-center mb-4 text-success">Restaurant Added/Updated Successfully </h3>

        <table class="table table-bordered table-striped">
            <tr>
                <th>Restaurant Name</th>
                <td>${zomatoDto.name}</td>
            </tr>
            <tr>
                <th>Owner Name</th>
                <td>${zomatoDto.ownerName}</td>
            </tr>
            <tr>
                <th>Owner Age</th>
                <td>${zomatoDto.ownerAge}</td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>${zomatoDto.phoneNo}</td>
            </tr>
            <tr>
                <th>Branch</th>
                <td>${zomatoDto.branch}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${zomatoDto.address}</td>
            </tr>
            <tr>
                <th>Pincode</th>
                <td>${zomatoDto.pincode}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${zomatoDto.city}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${zomatoDto.state}</td>
            </tr>
            <tr>
                <th>Country</th>
                <td>${zomatoDto.country}</td>
            </tr>
        </table>

        <div class="text-center mt-4">
            <a href="ZomatoForm.jsp" class="btn btn-primary">Add Another Restaurant</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
