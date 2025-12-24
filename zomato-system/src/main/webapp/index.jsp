<!DOCTYPE html>
<html>
<head>
    <title>Zomato</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <a class="navbar-brand" href="#">Zomato</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
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

<!-- Content -->
<div class="container text-center mt-5">
    <h2 class="mb-4">Add Restaurant</h2>
    <a href="ZomatoForm.jsp" class="btn btn-danger btn-lg">
        Open Zomato Form
    </a>
</div>

<!-- Content -->
<div class="container text-center mt-5">
    <h2 class="mb-4">Search Restaurant</h2>
    <a href="Search.jsp" class="btn btn-danger btn-lg">
        Search
    </a>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
