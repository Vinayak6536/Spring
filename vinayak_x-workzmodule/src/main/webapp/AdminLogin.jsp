<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

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

        .admin-icon {
                    border-radius: 50%;
                    border: 2px solid #ffc107;   /* optional yellow border */
                    padding: 4px;               /* space inside circle */
                    transition: transform 0.2s ease;
                }

                .admin-icon:hover {
                    transform: scale(1.1);
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

.page-section {
            display: none;
        }

        footer {
                    background-color: #212529;
                    color: white;
                }
    </style>

    <script>
        function validateLogin() {
                let value = document.getElementById("emailOrPhone").value.trim();
                let error = document.getElementById("emailOrPhoneError");
                error.innerText = "";

                // Email regex
                let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                // Indian mobile number (starts 6–9, 10 digits)
                let phoneRegex = /^[6-9]\d{9}$/;

                if (value === "") {
                    error.innerText = "Email or Mobile Number is required";
                    return false;
                }

                if (!emailRegex.test(value) && !phoneRegex.test(value)) {
                    error.innerText = "Enter valid Email or Mobile Number";
                    return false;
                }


            if (!passwordPattern.test(password)) {
                document.getElementById("passwordError").innerText =
                    "Password must be at least 8 characters and strong";
                return = false;
            }

            return true;
        }
    </script>
</head>

<body>
<nav class="navbar navbar-dark bg-dark">
    <div class="container d-flex align-items-center">

        <a href="index.jsp" onclick="showSection('home')">
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
<div class="page-content">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">

                <div class="card shadow">
                    <div class="card-header bg-dark text-white text-center">
                        <h4>Admin Login</h4>
                    </div>

                    <div class="card-body">
                    <c:if test="${not empty updatePassword}">
                        <p class="text-center fs-4 fw-bold text-uppercase text-success">
                            ${updatePassword}
                        </p>
                    </c:if>
                    <c:if test="${not empty notExist}">
                                            <p class="text-center fs-4 fw-bold text-success">
                                                ${notExist}
                                            </p>
                                        </c:if>
                       <c:if test="${not empty wrongPassword}">
                                            <p class="text-center fs-4 fw-bold text-success">
                                                ${wrongPassword }
                                            </p>
                                        </c:if>
                        <form action="<%= request.getContextPath() %>/AdminLogin" method="get" onsubmit="return validateLogin()">

                            <div class="mb-3">
                                <label>Email or Mobile Number</label>
                                <input type="text"
                                       name="emailOrPhone"
                                       id="emailOrPhone"
                                       class="form-control"
                                       placeholder="Enter email or mobile number"
                                       value="${emailOrPhoneno}" required>
                                <div id="emailOrPhoneError" class="error"></div>
                            </div>


                            <div class="mb-3">
                                <label>Password</label>
                                <input type="password" name="password" id="password" class="form-control"
                                placeholder="Enter Password">
                                <div id="passwordError" class="error"></div>
                            </div>

                            <div class="d-grid mb-3">
                                <button class="btn btn-warning btn-lg">
                                    Login
                                </button>
                            </div>
                       <c:if test="${not empty message}"> <p class="text-center fs-4 fw-bold text-uppercase text-danger">${ message }</p> </c:if>

                            <div class="text-center mt-3">


                         <%--       <div class="d-flex justify-content-center align-items-center gap-3">
                                  <p class="mb-2">Don’t have an account?</p>  <a href="SignUp.jsp" class="btn btn-outline-primary">
                                        Sign Up
                                    </a>
</div>
<div>
<a href="ChangePassword" class="btn btn-link p-0">
                                        Change Password?
                                    </a>
                                    <span class="text-muted">|</span>
          --%>
                             <div>
                                    <a href="ForgotPassword.jsp" class="btn btn-link p-0">
                                        Forgot Password?
                                    </a>
                                </div>
                            </div>



                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
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
<footer class="text-center py-3 bg-dark text-white">
    © 2026 My Application. All rights reserved.
</footer>
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
