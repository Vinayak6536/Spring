<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f9;
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
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            height: 100%;
        }

        .dashboard-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.25);
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

        .info-row {
            display: flex;
            justify-content: space-between;
            padding: 12px 0;
            border-bottom: 1px dashed #ccc;
            font-size: 16px;
        }

        .info-row span {
            color: #6c757d;
        }

        .info-row strong {
            color: #212529;
        }
    </style>
</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container d-flex align-items-center">

        <a href="index.jsp">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="ms-4 d-flex align-items-center">
            <span class="nav-link-custom">About</span>
            <span class="nav-link-custom">Fields</span>
            <span class="nav-link-custom">Contact</span>
        </div>

        <div class="ms-auto admin-hover">
            <div class="d-flex align-items-center text-white">
                <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                     height="40" class="admin-icon me-2">
                <span class="fw-semibold">Admin</span>
            </div>

            <div class="admin-hover-card p-3 text-center">
                <h6 class="fw-bold mb-1">Admin User</h6>
                <p class="text-muted mb-3">admin@xworkz.com</p>
                <a href="SignOut.jsp" class="btn btn-danger btn-sm w-100">Logout</a>
            </div>
        </div>

    </div>
</nav>

<!-- ================= DASHBOARD ================= -->
<div class="container mt-5">
    <div class="row g-4 justify-content-center">

        <!-- Card 1 -->
        <div class="col-md-4">
            <div class="dashboard-card">
                <div class="dashboard-header">
                    Batch Details
                </div>

                <div class="p-4 text-center">
                    <div class="info-row">
                        <span>Batch ID</span>
                        <strong>XW-B101</strong>
                    </div>

                    <div class="info-row">
                        <span>Batch Leader</span>
                        <strong>Ravi Kumar</strong>
                    </div>

                    <a href="BatchDetails.jsp" class="btn btn-outline-primary w-100 mt-4">
                        <i class="bi bi-eye"></i> View Batch
                    </a>
                </div>
            </div>
        </div>

        <!-- Card 2 -->
        <div class="col-md-4">
            <div class="dashboard-card">
                <div class="dashboard-header green">
                    Batch Management
                </div>

                <div class="p-4 text-center">
                    <p class="text-muted mb-4">
                        Manage all batches and leaders
                    </p>

                    <a href="AllBatchList.jsp" class="btn btn-outline-success w-100 mb-3">
                        <i class="bi bi-list-ul"></i> View All Batches
                    </a>

                    <a href="CreateBatch.jsp" class="btn btn-outline-secondary w-100">
                        <i class="bi bi-plus-circle"></i> Create New Batch
                    </a>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
