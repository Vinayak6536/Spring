<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Theatre Management</title>

    <!-- Bootstrap CSS -->
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

            .card-link {
                    text-decoration: none;
                    color: inherit;
                }
                .card-link:hover .card {
                    transform: translateY(-5px);
                    transition: 0.3s;
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
<!-- HERO SECTION -->
<div class="container mt-5">
    <div class="row align-items-center">
        <div class="col-md-6">
            <h1 class="fw-bold">Welcome to Theatre Management</h1>
            <p class="text-muted">
                Manage theatres, screens, seating capacity and ticket pricing easily.
            </p>
            <a href="AddTheatre.jsp" class="btn btn-primary">Add Theatre</a>
            <a href="viewTheatres" class="btn btn-outline-secondary">View Theatres</a>
        </div>

        <div class="col-md-6 text-center">
            <img src="https://cdn-icons-png.flaticon.com/512/2921/2921822.png"
                 class="img-fluid" width="300" alt="Theatre">
        </div>
    </div>
</div>

<!-- FEATURES -->
<div class="container mt-5">
    <div class="row text-center g-4">

        <!-- Screens -->
        <div class="col-md-4">
            <a href="screens.html" class="card-link">
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">Screens</h5>
                        <p class="card-text">Manage multiple screens per theatre.</p>
                    </div>
                </div>
            </a>
        </div>

        <!-- Seating -->
        <div class="col-md-4">
            <a href="seating.html" class="card-link">
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">Seating</h5>
                        <p class="card-text">Track total seating capacity.</p>
                    </div>
                </div>
            </a>
        </div>

        <!-- Ticket Price -->
        <div class="col-md-4">
            <a href="ticket.html" class="card-link">
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">Ticket Price</h5>
                        <p class="card-text">Maintain ticket pricing easily.</p>
                    </div>
                </div>
            </a>
        </div>

    </div>
</div>
</main>
<jsp:include page="footer.jsp"/>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

