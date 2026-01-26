<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Xworkz Module</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
        }
        .content {
            flex: 1;
        }
        footer {
            background-color: #212529;
            color: white;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container">

        <a href="index.jsp">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="ms-auto d-flex align-items-center">
            <!-- Profile Icon -->
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png"
                 height="40"
                 class="rounded-circle me-3"
                 style="cursor:pointer;"
                 data-bs-toggle="modal"
                 data-bs-target="#profileModal">

            <a href="SignOut.jsp" class="btn btn-outline-light">Logout</a>
        </div>

    </div>
</nav>


<div class="content d-flex align-items-center">
    <div class="container text-center">
        <h6 class="text-uppercase text-muted">We Are</h6>

        <h1 class="fw-bold mt-2">Experienced Trainers</h1>

        <div class="fs-1 fw-bold text-warning">_</div>

        <p class="mt-3">
            <a href="SignUp.jsp" class="text-decoration-none fw-semibold">
                Click here for registration
            </a>
        </p>

        <a href="#" class="btn btn-warning btn-lg mt-2">
            Enroll Now
        </a>

        <h5 class="mt-4 fw-semibold">Coding</h5>
    </div>
</div>

<footer class="text-center py-3">
    © 2026 My Application. All rights reserved.
</footer>

</body>
</html>
