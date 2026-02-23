<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
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
            background: rgba(255, 255, 255, 0.8);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.2);
        }
    </style>
    <script>
        function confirmDelete(studentId) {
            if (confirm("Are you sure you want to deactivate this student?")) {
                window.location.href = "deleteStudent?studentId=" + studentId;
            }
        }
    </script>
</head>

<body>

<!-- ================= NAVBAR (SAME) ================= -->
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
                <span class="fw-semibold">${admin.firstName}</span>
            </div>

            <div class="admin-hover-card p-3 text-center">
                <h6 class="fw-bold mb-1">${admin.firstName}</h6>
                <p class="text-muted mb-3">${admin.email}</p>
                <a href="logout" class="btn btn-danger btn-sm w-100">Logout</a>
            </div>
        </div>
    </div>
</nav>

<!-- ================= STUDENT RESULT ================= -->
<div class="container my-5">
    <div class="glass-card p-4">

        <h3 class="text-center fw-bold mb-4">Student List</h3>

       <!-- CHOOSE WHICH LIST TO USE -->
           <c:choose>

               <%-- WHEN BATCH WISE STUDENTS --%>
               <c:when test="${not empty getStudentsByBatchId}">
                   <c:set var="students" value="${getStudentsByBatchId}" />
               </c:when>

               <%-- OTHERWISE ALL STUDENTS --%>
               <c:otherwise>
                   <c:set var="students" value="${studentList}" />
               </c:otherwise>

           </c:choose>


         <%-- Delete Message --%>
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


           <%-- TABLE --%>
           <c:if test="${not empty students}">
               <div class="table-responsive">
                   <table class="table table-bordered table-hover align-middle text-center">

                       <thead class="table-primary">
                       <tr>
                           <th>ID</th>
                           <th>ProfileImage</th>
                           <th>Name</th>
                           <th>Email</th>
                           <th>Phone</th>
                           <th>Age</th>
                           <th>Gender</th>
                           <th>Qualification</th>
                           <th>College</th>
                           <th>Address</th>
                           <th>Joined Date</th>
                           <th>Edit</th>
                           <th>Delete</th>
                       </tr>
                       </thead>

                       <tbody>
                       <c:forEach var="student" items="${students}">
                           <tr>
                               <td>${student.studentId}</td>
                               <td><c:set var="imageBoxId" value="studentImageBox"/>
                                   <c:set var="inputId" value="studentImageInput"/>
                                   <c:set var="inputName" value="file"/>
                                   <c:set var="imagePath" value="${student.imagePath}" />
                                   <c:set var="displayName" value="${student.studentName}"/>
                                   <c:set var="isEdit" value="false"/>
                               <%@ include file="avatar.jspf" %> </td>
                               <td>${student.studentName}</td>
                               <td>${student.email}</td>
                               <td>${student.phone}</td>
                               <td>${student.age}</td>
                               <td>${student.gender}</td>
                               <td>${student.qualification}</td>
                               <td>${student.collegeName}</td>
                               <td>${student.address}</td>
                               <td>${student.joinedDate}</td>

                               <td>
                                   <a href="editStudent?studentId=${student.studentId}"
                                      class="btn btn-warning btn-sm">
                                       Edit
                                   </a>
                               </td>

                               <td>
                                   <button class="btn btn-danger btn-sm"
                                           onclick="confirmDelete(${student.studentId})">
                                       Delete
                                   </button>
                               </td>
                           </tr>
                       </c:forEach>
                       </tbody>

                   </table>
               </div>
           </c:if>

           <c:if test="${empty students}">
               <div class="alert alert-warning text-center">
                   No students found
               </div>
           </c:if>

       </div>
</div>

<!-- ================= SAME SCRIPT ================= -->
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
