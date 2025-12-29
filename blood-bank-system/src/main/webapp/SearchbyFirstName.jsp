<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Search Donor</title>

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

<!-- SEARCH FORM -->
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-danger text-white">
            <h5 class="mb-0">Search Donor by First Name</h5>
        </div>

        <div class="card-body">
            <form action="searchByFirstName" method="get" class="row g-3">
                <div class="col-md-6">
                    <input type="text" name="firstName" class="form-control"
                           placeholder="Enter First Name" required>
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-danger">
                        Search
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- RESULT TABLE -->
    <c:if test="${not empty donorList}">
        <div class="card mt-4 shadow">
            <div class="card-header bg-dark text-white">
                <h5 class="mb-0">Search Results</h5>
            </div>

            <div class="table-responsive">
                <table class="table table-bordered table-striped table-hover text-center mb-0">
                    <thead class="table-secondary">
                        <tr>
                            <th>Donor ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>DOB</th>
                            <th>ZIP Code</th>
                            <th>Email</th>
                            <th>Phone</th>
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
