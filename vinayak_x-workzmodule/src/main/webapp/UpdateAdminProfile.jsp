<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Profile Update</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }
        .page-content {
            flex: 1;
        }
        .error {
            color: red;
            font-size: 14px;
        }


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

                    background-color: #212529;
                    color: white;
                }
    </style>

    <script>
    const namePattern = /^[A-Za-z]+$/;
    const phonePattern = /^[6-9]\d{9}$/;
    const passwordPattern =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$/;

    function validateFirstName() {
        const value = firstName.value.trim();
        if (value === "") {
            firstNameError.innerText = "First name is required";
            return false;
        }
        if (!namePattern.test(value)) {
            firstNameError.innerText = "Only letters allowed";
            return false;
        }
        firstNameError.innerText = "";
        updateAvatar();
        return true;
    }

    function validateLastName() {
        const value = lastName.value.trim();
        if (value === "") {
            lastNameError.innerText = "Last name is required";
            return false;
        }
        if (!namePattern.test(value)) {
            lastNameError.innerText = "Only letters allowed";
            return false;
        }
        lastNameError.innerText = "";
        updateAvatar();
        return true;
    }

    function validateAge() {
        const value = age.value;
        if (value === "") {
            ageError.innerText = "Age is required";
            return false;
        }
        if (value < 18 || value > 120) {
            ageError.innerText = "Age must be between 18 and 120";
            return false;
        }
        ageError.innerText = "";
        return true;
    }

    function validateGender() {
        const gender = document.querySelector('input[name="gender"]:checked');
        if (!gender) {
            genderError.innerText = "Select gender";
            return false;
        }
        genderError.innerText = "";
        return true;
    }

    function validatePhone() {
        const value = phoneNo.value.trim();
        if (!phonePattern.test(value)) {
            phoneError.innerText =
                "Mobile number must start with 6-9 and be 10 digits";
            return false;
        }
        phoneError.innerText = "";
        return true;
    }

    function validateEmail() {
        const value = email.value.trim();
        if (value === "") {
            emailError.innerText = "Email is required";
            return false;
        }
        emailError.innerText = "";
        return true;
    }

    function validateForm() {
        return (
            validateFirstName() &&
            validateLastName() &&
            validateAge() &&
            validateGender() &&
            validatePhone() &&
            validateEmail()
        );
    }
    </script>


</head>

<body>
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
                       <div class="fw-bold">${admin.firstName}</div>
                       <small class="text-muted">${admin.email}</small>
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
<div class="page-content">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <div class="card shadow">
                    <div class="card-header bg-dark text-white text-center">
                        <h4>Update Admin Profile</h4>
                    </div>

                    <div class="card-body">
                       <form action="updateAdminProfile" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">

                       <c:if test="${not empty success}"> <p class="text-center fs-4 fw-bold  text-green">${ success }</p> </c:if>
                       <c:if test="${not empty fail}"> <p class="text-center fs-4 fw-bold  text-danger">${ fail }</p> </c:if>

                       <c:set var="imageBoxId" value="adminImageBox"/>
                       <c:set var="inputId" value="adminImageInput"/>
                       <c:set var="inputName" value="file"/>
                       <c:set var="imagePath" value="${editProfile.path}"/>
                       <c:set var="displayName" value="${editProfile.firstName}"/>
                       <c:set var="isEdit" value="true"/>

                       <%@ include file="avatar.jspf" %>


                       <div class="mb-2">
                           <label>First Name</label>
                           <input type="text" id="firstName" name="firstName"
                                  class="form-control" oninput="validateFirstName()" value="${editProfile.firstName}" required>
                           <div id="firstNameError" class="error">${firstNameError}</div>

                       </div>

                       <div class="mb-2">
                           <label>Last Name</label>
                           <input type="text" id="lastName" name="lastName"
                                  class="form-control" oninput="validateLastName()" value="${editProfile.lastName}" required>
                           <div id="lastNameError" class="error">${lastNameError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Age</label>
                           <input type="number" id="age" name="age"
                                  class="form-control" min="18" max="120"
                                  oninput="validateAge()" value="${editProfile.age}" required>
                           <div id="ageError" class="error">${ageError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Gender</label><br>
                           <input type="radio" name="gender" value="Male"
                                  onchange="validateGender()"> Male
                           <input type="radio" name="gender" value="Female"
                                  class="ms-3" onchange="validateGender()"> Female
                           <div id="genderError" class="error">${genderError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Mobile Number</label>
                           <input type="text" id="phoneNo" name="phoneNo"
                                  class="form-control" maxlength="10"
                                  oninput="validatePhone()" value="${editProfile.phoneNo}" required>
                           <div id="phoneError" class="error">${phoneError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Email</label>
                           <input type="email" id="email" name="email"
                                  class="form-control" oninput="validateEmail()" value="${editProfile.email}" readonly required>
                           <div id="emailError" class="error">${emailError}</div>
                       </div>

                      <div class="d-grid gap-3">
                          <button type="submit" class="btn btn-warning btn-lg">
                              Update Profile
                          </button>

                          <a href="adminProfileDetails" class="btn btn-secondary btn-lg">
                              Back
                          </a>
                      </div>

                       </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<footer class="text-center py-3 bg-dark text-white">
    © 2026 My Application. All rights reserved.
</footer>

<%@ include file="avatar-script.jspf" %>

</body>
</html>
