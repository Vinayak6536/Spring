<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .admin-hover:hover .admin-hover-card {
            display: block;
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

        .page-section {
            display: none;
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

        <a href="#" onclick="showBatches()">
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
                <span class="fw-semibold">Admin</span>
            </div>

            <div class="admin-hover-card p-3 text-center">
                <h6 class="fw-bold mb-1">${admin.name}</h6>
                <p class="text-muted mb-3">${admin.email}</p>
                <a href="logout" class="btn btn-danger btn-sm w-100">Logout</a>
            </div>
        </div>

    </div>
</nav>

<!-- ================= AUTO BATCH CARDS ================= -->
<div class="container my-5 flex-grow-1" id="batchSection">
    <div class="row g-4 justify-content-center">

        <!-- AUTO CARD GENERATION -->
        <c:forEach items="${batchList}" var="batch">

            <div class="col-md-5 col-lg-4">
                <div class="dashboard-card">

                    <div class="dashboard-header">
                        Batch
                    </div>

                    <div class="batch-card-body">
                        <img src="<%= request.getContextPath() %>/resources/static/${batch.image}"
                             class="batch-logo">

                        <div class="w-100">
                            <div class="info-row">
                                <span>Batch ID</span>
                                <strong>${batch.batchId}</strong>
                            </div>

                            <div class="info-row">
                                <span>Trainer</span>
                                <strong>${batch.trainerName}</strong>
                            </div>

                            <a href="viewBatch?batchId=${batch.batchId}"
                               class="btn btn-outline-primary w-100 mt-3">
                                <i class="bi bi-eye"></i> View Batch
                            </a>
                        </div>
                    </div>

                </div>
            </div>

        </c:forEach>

        <!-- IF NO BATCHES -->
        <c:if test="${empty batchList}">
            <div class="text-center text-muted fs-5">
                No batches available
            </div>
        </c:if>

    </div>
</div>

<!-- ================= ABOUT ================= -->
<section id="about" class="page-section py-5 bg-light">
    <div class="container text-center">
        <h2 class="fw-bold">About Us</h2>
        <p>Xworkz provides industry-focused training with expert mentors.</p>
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
        <h2 class="fw-bold">Contact</h2>
        <p>Bangalore, India | support@xworkz.com</p>
    </div>
</section>

<footer class="text-center py-3 mt-auto">
    © 2026 My Application
</footer>

<!-- ================= SCRIPT ================= -->
<script>
    function showSection(sectionId) {
        document.querySelectorAll('.page-section').forEach(sec => sec.style.display = 'none');
        document.getElementById(sectionId).style.display = 'block';
    }

    function showBatches() {
        document.querySelectorAll('.page-section').forEach(sec => sec.style.display = 'none');
        document.getElementById('batchSection').style.display = 'block';
    }
</script>

</body>
</html>
