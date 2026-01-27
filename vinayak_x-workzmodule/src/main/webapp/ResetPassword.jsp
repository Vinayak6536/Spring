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
        footer {
                    background-color: #212529;
                    color: white;
                }
    </style>
    <script>
     const passwordPattern =
            /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$/;

function validatePassword() {
        const value = password.value;
        if (!passwordPattern.test(value)) {
            passwordError.innerText =
                "Password must contain uppercase, lowercase, number & special character";
            return false;
        }
        passwordError.innerText = "";
        return true;
    }

    function validateConfirmPassword() {
        if (password.value !== confirmPassword.value) {
            confirmPasswordError.innerText = "Passwords do not match";
            return false;
        }
        confirmPasswordError.innerText = "";
        return true;
    }

    function validateForm() {
            return (validatePassword() &
                                validateConfirmPassword()
                            );
</script>
</head>

<body>
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
<a href="index.jsp"><img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40"></a>

        <div class="ms-auto">
            <a href="AdminLogin.jsp" class="btn btn-outline-light me-2">Sign In</a>
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
                        <h4>Reset Password</h4>
                    </div>

                    <div class="card-body">
<c:if test="${not empty verifyOtp}">
    <p class="text-center fs-4 fw-bold text-uppercase text-success">
        ${verifyOtp}
    </p>
</c:if>
                        <form action="<%= request.getContextPath() %>/resetPassword" method="post">

                           <div class="mb-3">
                                    <label>Email or Mobile Number</label>
                                    <input type="text"
                                           name="emailOrPhone"
                                           value="${emailOrPhone}"
                                           class="form-control"
                                           required>
                                </div>
                       <div class="mb-2">
                           <label>Password</label>
                           <input type="password" id="password" name="password"
                                  class="form-control" placeholder="Enter Password" oninput="validatePassword()" required>
                           <div id="passwordError" class="error">${passwordError}</div>
                       </div>

                       <div class="mb-3">
                           <label>Confirm Password</label>
                           <input type="password" id="confirmPassword" name="confirmPassword"
                                  class="form-control" placeholder="Re-Enter same Password" oninput="validateConfirmPassword()" required>
                           <div id="confirmPasswordError" class="error">${confirmPasswordError}</div>
                       </div>
                       <button class="btn btn-warning btn-lg w-100">Reset Password</button>

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
