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
    <div class="container">
<a href="index.jsp"><img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40"></a>

        <div class="ms-auto">
            <a href="SignIn.jsp" class="btn btn-outline-light me-2">Sign In</a>
            <a href="SignUp.jsp" class="btn btn-warning">Sign Up</a>
        </div>
    </div>
</nav>
<div class="page-content">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">

                <div class="card shadow">
                    <div class="card-header bg-dark text-white text-center">
                        <h4>Sign In</h4>
                    </div>

                    <div class="card-body">
                    ${success}
                        <form action="<%= request.getContextPath() %>/signIn" method="get" onsubmit="return validateLogin()">

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

                            <!-- SIGN UP LINK -->
                            <div class="text-center mt-3">
                                <p class="mb-2">Don't have an account?</p>
                                <a href="SignUp.jsp" class="btn btn-outline-primary">
                                    Sign Up
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

</body>
</html>
