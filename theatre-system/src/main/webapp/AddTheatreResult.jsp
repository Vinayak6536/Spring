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
<jsp:include page="navbar.jsp"/>

<main>
<div class="container mt-5">
    <div class="card shadow text-center">
        <div class="card-header bg-success text-white">
            Theatre Added Successfully!
        </div>
        <div class="card-body">
            <h5 class="card-title">Your theatre has been added.</h5>
            <p class="card-text">You can now view it in the list of theatres or add another theatre.</p>
            <a href="ViewTheatres.jsp" class="btn btn-primary me-2">View Theatres</a>
            <a href="AddTheatre.jsp" class="btn btn-outline-secondary">Add Another</a>
        </div>
    </div>
</div>
</main>
<jsp:include page="footer.jsp"/>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

