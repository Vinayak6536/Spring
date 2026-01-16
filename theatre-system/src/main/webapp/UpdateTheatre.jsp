<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Theatre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">Theatre</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="AddTheatre.jsp">Add Theatre</a></li>
                <li class="nav-item"><a class="nav-link" href="viewTheatres">View Theatres</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            Update Theatre
        </div>
        <div class="card-body">
            <form action="<%= request.getContextPath() %>/updateTheatre" method="post">
                <input type="hidden" name="theatreId" value="${theatre.theatreId}"/>
                <div class="mb-3">
                    <label class="form-label">Theatre Name</label>
                    <input type="text" name="theatreName" class="form-control"
                           value="${theatre.theatreName}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Location</label>
                    <input type="text" name="location" class="form-control"
                           value="${theatre.location}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">City</label>
                    <input type="text" name="city" class="form-control"
                           value="${theatre.city}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Owner Name</label>
                    <input type="text" name="ownerName" class="form-control"
                           value="${theatre.ownerName}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Total Screens</label>
                    <input type="number" name="totalScreens" class="form-control"
                           value="${theatre.totalScreens}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Total Seats</label>
                    <input type="number" name="totalSeats" class="form-control"
                           value="${theatre.totalSeats}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ticket Price</label>
                    <input type="number" step="0.01" name="ticketPrice" class="form-control"
                           value="${theatre.ticketPrice}" required>
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" name="acAvailable" class="form-check-input"
                           ${theatre.acAvailable ? 'checked' : ''}>
                    <label class="form-check-label">AC Available</label>
                </div>
                <div class="mb-3">
                    <label class="form-label">Contact Number</label>
                    <input type="text" name="contactNumber" class="form-control"
                           value="${theatre.contactNumber}" required>
                </div>
                <button type="submit" class="btn btn-success">Update Theatre</button>
                <a href="viewTheatres" class="btn btn-secondary ms-2">Cancel</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
