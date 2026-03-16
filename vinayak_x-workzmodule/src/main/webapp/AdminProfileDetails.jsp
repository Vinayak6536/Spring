<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile Updated</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

    <%-- SAME STYLE (navbar + hover) --%>
    <style>
        body {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            background-color: #f4f6f9;
        }

        .page-content {
            flex: 1;
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
            opacity: 0;
            visibility: hidden;
            transform: translateY(-8px);
            position: absolute;
            right: 0;
            top: 55px;
            width: 270px;
            background: white;
            border-radius: 16px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.2);
            z-index: 1000;
            transition: 0.3s;
        }

        .admin-hover:hover .admin-hover-card,
        .admin-hover-card:hover {
            opacity: 1;
            visibility: visible;
            transform: translateY(0);
        }

        .admin-profile-img {
            width: 55px;
            height: 55px;
            border-radius: 50%;
            object-fit: cover;
            border: 2px solid #0d6efd;
            padding: 2px;
            background: #fff;
        }

        /* RESULT STYLE (different) */
        .result-box {
            max-width: 720px;
            margin: auto;
            padding: 35px;
        }

        .success-line {
            background: #e7f7ef;
            color: #198754;
            font-weight: 600;
            border-radius: 12px;
            padding: 14px;
            text-align: center;
            margin-bottom: 25px;
        }

        .detail-row {
            background: #fff;
            border-radius: 14px;
            padding: 18px 22px;
            margin-bottom: 14px;
            box-shadow: 0 8px 18px rgba(0,0,0,0.08);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .detail-label {
            font-size: 13px;
            text-transform: uppercase;
            letter-spacing: 1px;
            color: #6c757d;
        }

        .detail-value {
            font-size: 17px;
            font-weight: 600;
            color: #212529;
        }

        footer {
            background-color: #212529;
            color: white;
        }
    </style>

    <%-- SAME SCRIPT --%>
    <script>
        function showSection(section) {
            console.log(section);
        }
    </script>
</head>

<body>

<%-- ✅ SAME NAVBAR --%>
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
                <span class="fw-semibold">${admin.firstName}</span>
            </div>

            <div class="admin-hover-card p-3">
                <div class="d-flex align-items-center mb-3">
                    <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                         class="admin-profile-img me-3">
                    <div>
                        <div class="fw-bold">${admin.firstName}</div>
                        <small class="text-muted">${admin.email}</small>
                    </div>
                </div>

                <div class="d-grid gap-2">
                    <a href="viewProfile?email=${admin.email}"
                       class="btn btn-outline-primary btn-sm">
                        👤 View Profile
                    </a>
                    <a href="logout" class="btn btn-danger btn-sm">
                        🚪 Logout
                    </a>
                </div>
            </div>
        </div>

    </div>
</nav>

<%-- ✅ DIFFERENT CONTENT --%>
<div class="page-content">
    <div class="result-box">

        <div class="success-line">
            Admin Profile
        </div>

        <%-- ✅ SET VALUES FOR AVATAR --%>
        <c:set var="imageBoxId" value="profileImageBox"/>
        <c:set var="inputId" value="profileImageInput"/>
        <c:set var="inputName" value="file"/>
        <c:set var="imagePath" value="${viewProfile.path}"/>
        <c:set var="displayName" value="${viewProfile.firstName}"/>
        <c:set var="isEdit" value="false"/>

        <%@ include file="avatar.jspf" %>

        <div class="detail-row">
            <span class="detail-label">Full Name</span>
            <span class="detail-value">
                ${viewProfile.firstName} ${viewProfile.lastName}
            </span>
        </div>

        <div class="detail-row">
            <span class="detail-label">Email</span>
            <span class="detail-value">${viewProfile.email}</span>
        </div>

        <div class="detail-row">
            <span class="detail-label">Age</span>
            <span class="detail-value">${viewProfile.age}</span>
        </div>

        <div class="detail-row">
            <span class="detail-label">Gender</span>
            <span class="detail-value">${viewProfile.gender}</span>
        </div>

        <div class="detail-row">
            <span class="detail-label">Mobile</span>
            <span class="detail-value">${viewProfile.phoneNo}</span>
        </div>

        <div class="d-grid gap-2 mt-4">
            <a href="editProfile?email=${admin.email}"
               class="btn btn-outline-secondary btn-lg">
               Edit Profile
            </a>

            <a href="AdminPage.jsp"
               class="btn btn-dark btn-lg">
               Back to Dashboard
            </a>
        </div>

    </div>
</div>

<footer class="text-center py-3 bg-dark text-white">
    © 2026 My Application. All rights reserved.
</footer>

<%@ include file="avatar-script.jspf" %>


</body>
</html>
