<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Batch Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

    <style>
        html, body { height: 100%; }
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

        .nav-link-custom:hover { text-decoration: underline; }

        .admin-icon {
            border-radius: 50%;
            border: 2px solid #ffc107;
            padding: 4px;
        }

        .admin-hover { position: relative; cursor: pointer; }

        .admin-hover-card {
            display: none;
            position: absolute;
            right: 0;
            top: 55px;
            width: 240px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.2);
            z-index: 1000;
        }

        .admin-hover:hover .admin-hover-card { display: block; }

        .dashboard-card {
            border-radius: 22px;
            background: linear-gradient(135deg, #ffffff, #f1f4f9);
            box-shadow: 0 14px 30px rgba(0,0,0,0.15);
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

        .batch-logo {
            width: 90px;
            height: 90px;
            border-radius: 15px;
            border: 2px solid #dee2e6;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px dashed #ccc;
        }

        .page-section { display: none; }

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

        <a href="adminDashboard">
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

            <div class="admin-hover-card p-3 text-center">
                <h6 class="fw-bold mb-1">${admin.getFirstName()}</h6>
                <p class="text-muted mb-3">${admin.getEmail()}</p>
                <a href="logout" class="btn btn-danger btn-sm w-100">Logout</a>
            </div>
        </div>
    </div>
</nav>

<!-- ================= BATCH DETAILS ================= -->
<div class="container my-5 flex-grow-1">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="dashboard-card">

                <div class="dashboard-header">
                    ${batch.batchName}
                </div>

                <div class="p-4">

                <%--   <div class="text-center mb-4">
                        <img src="<%= request.getContextPath() %>/resources/static/${batch.image}"
                             class="batch-logo">
                    </div>  --%>

                    <div class="info-row">
                        <strong>Batch ID</strong>
                        <span>${batch.batchId}</span>
                    </div>

                    <div class="info-row">
                        <strong>Batch Name</strong>
                        <span>${batch.batchName}</span>
                    </div>

                    <div class="info-row">
                        <strong>Start Date</strong>
                        <span>${batch.batchStartDate}</span>
                    </div>

                    <div class="info-row">
                        <strong>End Date</strong>
                        <span>${batch.batchEndDate}</span>
                    </div>

                    <div class="info-row">
                        <strong>Trainer</strong>
                        <span>${batch.batchTrainer}</span>
                    </div>

                    <div class="mt-4 text-center">
                        <a href="students?batchId=${batch.batchId}" class="btn btn-success me-2">
                            Registered Students
                        </a>

                        <a href="StudentRegForm.jsp" class="btn btn-success me-2">
                            <i class="bi bi-person-plus"></i> Register Student
                        </a>

                        <a href="AdminPage.jsp" class="btn btn-secondary">
                            <i class="bi bi-arrow-left"></i> Back
                        </a>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>

<!-- ================= ABOUT ================= -->
<section id="about" class="page-section py-5 bg-light">
    <div class="container text-center">
        <h2 class="fw-bold">About Us</h2>
        <p>Xworkz provides industry-focused training.</p>
    </div>
</section>

<!-- ================= FIELDS ================= -->
<section id="fields" class="page-section py-5">
    <div class="container text-center">
        <h2 class="fw-bold">Our Fields</h2>
        <div class="row mt-4">
            <div class="col-md-3">Java Full Stack</div>
            <div class="col-md-3">Spring MVC</div>
            <div class="col-md-3">Hibernate</div>
            <div class="col-md-3">SQL</div>
        </div>
    </div>
</section>

<!-- ================= CONTACT ================= -->
<section id="contact" class="page-section py-5 bg-light">
    <div class="container text-center">
        <h2 class="fw-bold">Contact</h2>
        <p>Bangalore | support@xworkz.com</p>
    </div>
</section>

<footer class="text-center py-3 mt-auto">
    © 2026 My Application
</footer>

<!-- ================= JS ================= -->
<script>
    function showSection(sectionId) {
        document.querySelectorAll('.page-section')
            .forEach(sec => sec.style.display = 'none');
        document.getElementById(sectionId).style.display = 'block';
    }
</script>

</body>
</html>
