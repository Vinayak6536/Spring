<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

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

        .glass-card {
            background: rgba(255, 255, 255, 0.7);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.2);
        }

        .page-section {
            display: none;
        }
    </style>
</head>
<%@ include file="avatar-script.jspf" %>

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

<!-- ================= STUDENT REG FORM ================= -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
              <c:if test="${not empty success}">
                <p class="text-center fs-4 fw-bold text-success">
                 ${success}
                </p>
              </c:if>
              <c:if test="${not empty fail}">
                <p class="text-center fs-4 fw-bold text-success">
                 ${fail}
                </p>
              </c:if>
            <div class="glass-card p-4">
                <h3 class="text-center mb-4 fw-bold">Student Registration</h3>

                <form action="addStudent" method="post" enctype="multipart/form-data"
                                                        class="dashboard-card"
                                                        accept-charset="UTF-8">
                     <c:if test="${fromBatch}">
                        <input type="number" name="batchId" value="${batch.batchId}" hidden required>
                    </c:if>

                    <c:set var="imageBoxId" value="studentImageBox"/>
                    <c:set var="inputId" value="studentImageInput"/>
                    <c:set var="inputName" value="file"/>
                    <c:set var="imagePath" value=""/>
                    <c:set var="displayName" value=""/>
                    <c:set var="isEdit" value="true"/>

                    <%@ include file="avatar.jspf" %>

                    <div class="mb-3">
                        <label>Student Name</label>
                        <input type="text" name="studentName" class="form-control" oninput="updateAvatar()" required >
                    </div>

                    <div class="mb-3">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label>Phone</label>
                        <input type="number" name="phone" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label>Age</label>
                        <input type="number" name="age" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label>Gender</label>
                        <select name="gender" class="form-select" required>
                            <option value="">Select</option>
                            <option>Male</option>
                            <option>Female</option>
                            <option>Other</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label>Qualification</label>
                        <input type="text" name="qualification" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label>College Name</label>
                        <input type="text" name="collegeName" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label>Address</label>
                        <textarea name="address" class="form-control"></textarea>
                    </div>

                    <div class="mb-3">
                        <label>Joined Date</label>
                        <input type="date" name="joinedDate" class="form-control">
                    </div>

                   <c:if test="${fromBatch == null or !fromBatch}">
                       <div class="mb-3">
                           <label class="form-label">Batch</label>
                           <select name="batchId" class="form-select" required>
                               <option value="">Select Batch</option>

                               <c:forEach var="batch" items="${batchList}">
                                   <option value="${batch.batchId}">
                                       ${batch.batchName} (ID: ${batch.batchId})
                                   </option>
                               </c:forEach>
                           </select>
                       </div>
                   </c:if>


                    <div class="mb-3">
                        <label>Status</label>
                        <select class="form-select" disabled>
                            <option selected>Active</option>
                        </select>

                        <input type="hidden" name="active" value="true">

                    </div>

                    <div class="d-grid gap-3">
                        <button type="submit" class="btn btn-success fw-bold">
                            Register Student
                        </button>

                        <a href="backAdminPage" class="btn btn-secondary">
                            <i class="bi bi-arrow-left"></i> Back
                        </a>
                    </div>


                </form>

            </div>

        </div>
    </div>
</div>

<!-- ================= JS ================= -->
<script>
    function showSection(sectionId) {
        const sections = document.querySelectorAll('.page-section');
        sections.forEach(sec => sec.style.display = 'none');

        const section = document.getElementById(sectionId);
        if (section) {
            section.style.display = 'block';
        }
    }
</script>

</body>
</html>
