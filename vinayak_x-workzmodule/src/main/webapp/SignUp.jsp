<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

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
        return (
            validateFirstName() &
            validateLastName() &
            validateAge() &
            validateGender() &
            validatePhone() &
            validateEmail() &
            validatePassword() &
            validateConfirmPassword()
        );
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
            <div class="col-md-6">

                <div class="card shadow">
                    <div class="card-header bg-dark text-white text-center">
                        <h4>Create Account</h4>
                    </div>

                    <div class="card-body">
                       <form action="signUp" method="post" onsubmit="return validateForm()">

                       <c:if test="${not empty exist}"> <p class="text-center fs-4 fw-bold text-uppercase text-danger">${ exist }</p> </c:if>

                       <%@ include file="avatar.jspf" %>



                       <div class="mb-2">
                           <label>First Name</label>
                           <input type="text" id="firstName" name="firstName"
                                  class="form-control" oninput="validateFirstName()" required>
                           <div id="firstNameError" class="error">${firstNameError}</div>

                       </div>

                       <div class="mb-2">
                           <label>Last Name</label>
                           <input type="text" id="lastName" name="lastName"
                                  class="form-control" oninput="validateLastName()" required>
                           <div id="lastNameError" class="error">${lastNameError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Age</label>
                           <input type="number" id="age" name="age"
                                  class="form-control" min="18" max="120"
                                  oninput="validateAge()" required>
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
                                  oninput="validatePhone()" required>
                           <div id="phoneError" class="error">${phoneError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Email</label>
                           <input type="email" id="email" name="email"
                                  class="form-control" oninput="validateEmail()" required>
                           <div id="emailError" class="error">${emailError}</div>
                       </div>

                       <div class="mb-2">
                           <label>Password</label>
                           <input type="password" id="password" name="password"
                                  class="form-control" oninput="validatePassword()" required>
                           <div id="passwordError" class="error">${passwordError}</div>
                       </div>

                       <div class="mb-3">
                           <label>Confirm Password</label>
                           <input type="password" id="confirmPassword" name="confirmPassword"
                                  class="form-control" oninput="validateConfirmPassword()" required>
                           <div id="confirmPasswordError" class="error">${confirmPasswordError}</div>
                       </div>


                       <button class="btn btn-warning btn-lg w-100">Register</button>
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
