<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Profile</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Job Profile</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="PersonalDetails.jsp">Personal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="EducationDetails.jsp">Education</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Experience.jsp">Experience</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Contact.jsp">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- CONTENT -->
<div class="container mt-5" style="max-width: 600px;">

    <!-- Personal -->
    <div class="card mb-3 shadow-sm">
        <a href="PersonalDetails.jsp" class="text-decoration-none text-dark">
            <div class="card-body d-flex align-items-center">
                <div class="me-3 fw-bold text-primary fs-5">01</div>
                <div class="flex-grow-1">
                    <h6 class="mb-1">Personal Details</h6>
                    <small class="text-muted">Basic personal information</small>
                </div>
                <span class="text-primary fw-semibold">→</span>
            </div>
        </a>
    </div>

    <!-- Education -->
    <div class="card mb-3 shadow-sm">
        <a href="EducationDetails.jsp" class="text-decoration-none text-dark">
            <div class="card-body d-flex align-items-center">
                <div class="me-3 fw-bold text-success fs-5">02</div>
                <div class="flex-grow-1">
                    <h6 class="mb-1">Education</h6>
                    <small class="text-muted">Academic qualifications</small>
                </div>
                <span class="text-success fw-semibold">→</span>
            </div>
        </a>
    </div>

    <!-- Experience -->
    <div class="card mb-3 shadow-sm">
        <a href="Experience.jsp" class="text-decoration-none text-dark">
            <div class="card-body d-flex align-items-center">
                <div class="me-3 fw-bold text-warning fs-5">03</div>
                <div class="flex-grow-1">
                    <h6 class="mb-1">Experience</h6>
                    <small class="text-muted">Work experience details</small>
                </div>
                <span class="text-warning fw-semibold">→</span>
            </div>
        </a>
    </div>

    <!-- Contact -->
    <div class="card mb-3 shadow-sm">
        <a href="Contact.jsp" class="text-decoration-none text-dark">
            <div class="card-body d-flex align-items-center">
                <div class="me-3 fw-bold text-info fs-5">04</div>
                <div class="flex-grow-1">
                    <h6 class="mb-1">Contact</h6>
                    <small class="text-muted">Communication details</small>
                </div>
                <span class="text-info fw-semibold">→</span>
            </div>
        </a>
    </div>

</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
