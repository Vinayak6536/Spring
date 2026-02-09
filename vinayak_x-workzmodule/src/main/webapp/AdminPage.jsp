<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }

        body {
            background-color: #f4f6f9;
            display: flex;
            flex-direction: column;
        }

        .nav-link-custom {
            color: white;
            margin-right: 25px;
            cursor: pointer;
        }

        .nav-link-custom:hover {
            text-decoration: underline;
        }

        .admin-icon {
            border-radius: 50%;
            border: 2px solid #ffc107;
            padding: 4px;
        }

        .admin-hover {
            position: relative;
            cursor: pointer;
        }

        /* Dropdown card */
        .admin-hover-card {
            opacity: 0;
            visibility: hidden;
            transform: translateY(-8px);

            position: absolute;
            right: 0;
            top: 55px;
            width: 240px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.2);
            z-index: 1000;

            transition:
                opacity 0.3s ease,
                transform 0.3s ease,
                visibility 0.3s;
        }

        /* SHOW on hover (icon + card both) */
        .admin-hover:hover .admin-hover-card,
        .admin-hover-card:hover {
            opacity: 1;
            visibility: visible;
            transform: translateY(0);
        }

        .dashboard-card {
            border-radius: 22px;
            background: linear-gradient(135deg, #ffffff, #f1f4f9);
            box-shadow: 0 14px 30px rgba(0,0,0,0.15);
            transition: 0.3s;
        }

        .dashboard-card:hover {
            transform: translateY(-8px);
        }

        .dashboard-header {
            padding: 18px;
            font-size: 20px;
            font-weight: 700;
            color: white;
            text-align: center;
            border-radius: 22px 22px 0 0;
            background: linear-gradient(135deg, #003366, #007bff);
        }

        .dashboard-header.green {
            background: linear-gradient(135deg, #198754, #20c997);
        }

        .batch-card-body {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 20px;
        }

        .batch-logo {
            width: 90px;
            height: 90px;
            border-radius: 15px;
            object-fit: cover;
            border: 2px solid #dee2e6;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px dashed #ccc;
        }

        /* sections hidden by default */
        .page-section {
            display: none;
        }

        .admin-hover-card {
            width: 260px;
            border-radius: 16px;
        }

        .dropdown-item {
            padding: 10px 12px;
            border-radius: 8px;
            text-decoration: none;
            color: #333;
            display: block;
        }

        .dropdown-item:hover {
            background-color: #f1f3f5;
        }

        .admin-hover-card {
            width: 270px;
            border-radius: 16px;
        }

        /* Clear profile image */
        .admin-profile-img {
            width: 55px;
            height: 55px;
            border-radius: 50%;
            object-fit: cover;
            border: 2px solid #0d6efd;
            padding: 2px;
            background: #fff;
        }

        /* Button polish */
        .admin-hover-card .btn {
            font-weight: 600;
            border-radius: 10px;
            padding: 8px;
        }

        /* Optional hover polish */
        .admin-hover-card .btn-outline-primary:hover {
            background-color: #0d6efd;
            color: #fff;
        }




        footer {
            background: #212529;
            color: white;
        }
    </style>
</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container d-flex align-items-center">

        <a href="AdminPage.jsp">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="d-flex align-items-center ms-4 gap-4">
            <span class="nav-link-custom" onclick="showSection('about')">About</span>
            <span class="nav-link-custom" onclick="showSection('fields')">Fields</span>
            <span class="nav-link-custom" onclick="showSection('contact')">Contact</span>
        </div>

       <div class="ms-auto admin-hover">
           <div class="d-flex align-items-center text-white">
               <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                    height="40" class="admin-icon me-2">
               <span class="fw-semibold">${admin.getFirstName()}</span>
           </div>

           <div class="admin-hover-card p-3">
               <!-- Profile section -->
               <div class="admin-profile d-flex align-items-center mb-3">
                   <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                        class="admin-profile-img me-3">
                   <div>
                       <div class="fw-bold">${admin.getFirstName()}</div>
                       <small class="text-muted">${admin.getEmail()}</small>
                   </div>
               </div>

               <div class="d-grid gap-2">
                   <a href="viewProfile?email=${admin.getEmail()}" class="btn btn-outline-primary btn-sm">
                       👤 View Profile
                   </a>
                   <a href="logout" class="btn btn-danger btn-sm">
                       🚪 Logout
                   </a>
               </div>
           </div>
       </div>


</nav>

<!-- ================= BATCH LIST (DEFAULT) ================= -->
<div class="container my-5 flex-grow-1" id="batchSection">
    <div class="row g-4 justify-content-center">

        <!-- Batches Card -->
        <div class="col-md-5">
            <div class="dashboard-card text-center p-4">
            <c:if test="${not empty success}">
                <p class="text-center fs-4 fw-bold text-uppercase text-success">
                    ${success}
                </p>
            </c:if>
                <div class="dashboard-header">
                    <i class="bi bi-journal-code me-2"></i> Batches
                </div>
                <div class="mt-4">
                    <h5>Learn with Experts</h5>
                    <p>Join our curated batches for Java, Python, and Web Development. Hands-on projects included!</p>
                </div>
                <a href="batchList" class="btn btn-primary w-75 mt-3">
                    <i class="bi bi-eye"></i> Explore Batches
                </a>
                   <a href="AddBatch.jsp" class="btn btn-primary w-75 mt-3">
                    <i class="bi bi-eye"></i> Add Batches
                </a>
            </div>
        </div>

        <!-- Students Card -->
        <div class="col-md-5">
            <div class="dashboard-card text-center p-4">
                <div class="dashboard-header green">
                    <i class="bi bi-people-fill me-2"></i> Students
                </div>
                <div class="mt-4">
                    <h5>Grow Your Skills</h5>
                    <p>Track and manage all enrolled students easily. Real-time progress and updates.</p>
                </div>
                <a href="<%= request.getContextPath()%>/studentsList" class="btn btn-success w-75 mt-3">
                    <i class="bi bi-eye"></i> View Students
                </a>

                <a href="registerStudent" class="btn btn-success w-75 mt-3">
                                    <i class="bi bi-eye"></i> Register Student
                                </a>
            </div>
        </div>

    </div>
</div>
<!-- ================= ABOUT ================= -->
<section id="about" class="page-section py-5 bg-light">
    <div class="container text-center">
        <h2 class="fw-bold">About Us</h2>
        <p class="mt-3">
            Xworkz provides industry-focused training with real-time projects and expert mentors.
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
            Bangalore, India<br>
            +91 9876543210<br>
            support@xworkz.com
        </p>
    </div>
</section>

<!-- ================= FOOTER ================= -->
<footer class="text-center py-3 mt-auto">
    © 2026 My Application. All rights reserved.
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
