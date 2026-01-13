<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Theatre Management</title>

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

<jsp:include page="navbar.jsp"/>

<main>
<div class="container mt-5">
    <div class="card shadow text-center">
        <div class="card-header bg-danger text-white">
            Operation Failed!
        </div>
        <div class="card-body">
            <h5 class="card-title">Something went wrong</h5>
            <p class="card-text">The theatre could not be saved, updated, or deleted. Please try again.</p>
        </div>
    </div>
</div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
