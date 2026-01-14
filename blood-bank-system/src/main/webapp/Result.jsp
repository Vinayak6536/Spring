<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Donor Search Result</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">My Application</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Registration.jsp">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                                    <a class="nav-link" href="SearchbyFirstName.jsp">Search</a>
                                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- MAIN CONTAINER -->
<div class="container mt-5 mb-5">

    <h3 class="text-center mb-4">Donor Search Results</h3>

    <!-- DATA AVAILABLE -->
    <c:if test="${not empty donorList}">
        <div class="card shadow">


            <div class="table-responsive">
                <table class="table table-bordered table-striped table-hover text-center mb-0 align-middle">
                    <thead class="table-secondary">
                        <tr>
                            <th>Donor ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>DOB</th>
                            <th>ZIP Code</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="donor" items="${donorList}">
                            <tr>
                                <td>${donor.donorId}</td>
                                <td>${donor.firstName}</td>
                                <td>${donor.lastName}</td>
                                <td>${donor.dob}</td>
                                <td>${donor.zipCode}</td>
                                <td>${donor.email}</td>
                                <td>${donor.phone}</td>
                                <td class="text-center">
                                    <a href="editBlood?firstName=${donor.firstName}"
                                       class="btn btn-sm btn-primary">
                                        Edit
                                    </a>
                                </td>
                                <td class="text-center">
                                     <a href="delete?donorId=${donor.donorId}"
                                     class="btn btn-sm btn-primary">
                                     Delete
                                 </a>
                                 </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

    <!-- NO DATA -->
    <c:if test="${empty donorList && searched}">
        <div class="alert alert-warning mt-4 text-center">
            No donors found with the given first name.
        </div>
    </c:if>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
