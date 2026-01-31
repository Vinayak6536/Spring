<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Xworkz Module</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">


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
        .nav-link-custom {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            cursor: pointer;
        }
        .nav-link-custom:hover {
            text-decoration: underline;
        }

        /* Hide sections by default */
        .page-section {
            display: none;
        }

        .admin-icon {
            border-radius: 50%;
            border: 2px solid #ffc107;   /* optional yellow border */
            padding: 4px;               /* space inside circle */
            transition: transform 0.2s ease;
        }

        .admin-icon:hover {
            transform: scale(1.1);
        }

    </style>
</head>
<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container d-flex align-items-center">

        <a href="#" onclick="showSection('home')">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="d-flex align-items-center ms-4 gap-4">
            <span class="nav-link-custom" onclick="showSection('about')">About</span>
            <span class="nav-link-custom" onclick="showSection('fields')">Fields</span>
            <span class="nav-link-custom" onclick="showSection('contact')">Contact</span>
        </div>

        <div class="ms-auto d-flex align-items-center">
            <a href="AdminLogin.jsp"
               class="d-flex align-items-center text-white text-decoration-none">

                <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                     height="40"
                     class="admin-icon me-2">

                <span class="fw-semibold">Admin Login</span>
            </a>
        </div>

    </div>
</nav>


<!-- ================= HOME (DEFAULT VISIBLE) ================= -->
<div id="home" class="content d-flex align-items-center page-section" style="display:block;">
    <div class="container text-center">
        <h6 class="text-uppercase text-muted">We Are</h6>
        <h1 class="fw-bold mt-2">Experienced Trainers</h1>
        <div class="fs-1 fw-bold text-warning">_</div>

        <p class="mt-3">
            <a href="#" class="text-decoration-none fw-semibold">
                Click here for registration
            </a>
        </p>

        <a href="SignUp.jsp" class="btn btn-warning btn-lg mt-2">
            Enroll Now
        </a>
    </div>
</div>

    <!-- ================= ABOUT ================= -->
    <section id="about" class="page-section py-5 bg-light">
        <div class="container text-center">
            <h2 class="fw-bold">About Us</h2>
            <p class="mt-3">
                Xworkz provides industry-focused training with real-time projects,
                expert mentors, and placement guidance to build strong IT careers.
            </p>
        </div>
    </section>

    <!-- ================= FIELDS ================= -->
    <section id="fields" class="page-section py-5">
        <div class="container text-center">
            <h2 class="fw-bold">Our Fields</h2>
            <div class="row mt-4">
                <div class="col-md-3">Java Full Stack</div>
                <div class="col-md-3">Web Development</div>
                <div class="col-md-3">Spring & Hibernate</div>
                <div class="col-md-3">SQL & Database</div>
            </div>
        </div>
    </section>

    <!-- ================= CONTACT ================= -->
    <section id="contact" class="page-section py-5 bg-light">
        <div class="container text-center">
            <h2 class="fw-bold">Contact Us</h2>
            <p class="mt-3">
                <i class="bi bi-geo-alt-fill"></i> Bangalore, India<br>
                <i class="bi bi-telephone-fill"></i> +91 9876543210<br>
                <i class="bi bi-envelope-fill"></i> support@xworkz.com
            </p>

        </div>
    </section>

<!-- ================= FOOTER ================= -->
<footer class="text-center py-3">
    © 2026 My Application. All rights reserved.<br>
</footer>

<!-- ================= JS FOR SHOW/HIDE ================= -->
<script>
    function showSection(sectionId) {
        // Hide all sections
        const sections = document.querySelectorAll('.page-section');
        sections.forEach(sec => sec.style.display = 'none');

        // Show selected section
        document.getElementById(sectionId).style.display = 'block';
    }
</script>

</body>
</html>
