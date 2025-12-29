<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Donor</title>

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

    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-dark text-white text-center">
                    <h5 class="mb-0">Update Donor Details</h5>
                </div>

                <div class="card-body">

                    <form action="<%= request.getContextPath() %>/updateBlood" method="post">
                        <div class="mb-3">
                            <label class="form-label">Donor ID</label>
                            <input type="text" class="form-control"
                                   name="donorId"
                                   value="${donor.donorId}">

                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">First Name</label>
                                <input type="text" class="form-control"
                                       name="firstName"
                                       value="${donor.firstName}">
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Last Name</label>
                                <input type="text" class="form-control"
                                       name="lastName"
                                       value="${donor.lastName}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">Date of Birth</label>
                                <input type="date" class="form-control"
                                       name="dob"
                                       value="${donor.dob}">
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">ZIP Code</label>
                                <input type="number" class="form-control"
                                       name="zipCode"
                                       value="${donor.zipCode}">
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control"
                                   name="email"
                                   value="${donor.email}">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Phone</label>
                            <input type="number" class="form-control"
                                   name="phone"
                                   value="${donor.phone}">
                        </div>

                        <!-- BUTTONS -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-success px-4">
                                Update
                            </button>
                            <a href="SearchbyFirstName.jsp" class="btn btn-secondary px-4">
                                Cancel
                            </a>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
