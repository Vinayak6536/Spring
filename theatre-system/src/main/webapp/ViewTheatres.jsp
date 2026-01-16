<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Theatres</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
        }
        main {
            flex: 1;
        }
    </style>
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

<main>
<div class="container mt-5">

    <h3 class="text-center mb-4">Theatre List</h3>

    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover shadow">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Location</th>
                    <th>City</th>
                    <th>Screens</th>
                    <th>Seats</th>
                    <th>Owner</th>
                    <th>AC</th>
                    <th>Ticket Price</th>
                    <th>Contact</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody class="text-center">
                <c:forEach var="theatre" items="${theatres}">
                    <tr>
                        <td>${theatre.theatreId}</td>
                        <td>${theatre.theatreName}</td>
                        <td>${theatre.location}</td>
                        <td>${theatre.city}</td>
                        <td>${theatre.totalScreens}</td>
                        <td>${theatre.totalSeats}</td>
                        <td>${theatre.ownerName}</td>
                        <td>${theatre.acAvailable}</td>
                        <td>${theatre.ticketPrice}</td>
                        <td>${theatre.contactNumber}</td>
                        <td>
                            <a href="editTheatre/${theatre.theatreId}" class="btn btn-warning btn-sm">
                                Edit
                            </a>
                        </td>
                         <td>
                                <a href="deleteTheatre/${theatre.theatreId}" class="btn btn-warning btn-sm">
                                    Delete
                                </a>
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
