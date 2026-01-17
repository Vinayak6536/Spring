<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

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
        function validateForm() {
            let valid = true;
            document.querySelectorAll(".error").forEach(e => e.innerText = "");

            const firstName = document.getElementById("firstName").value.trim();
            const lastName = document.getElementById("lastName").value.trim();
            const age = document.getElementById("age").value;
            const phone = document.getElementById("phoneNo").value.trim();
            const email = document.getElementById("email").value.trim();
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const gender = document.querySelector('input[name="gender"]:checked');

            const phonePattern = /^[6-9][0-9]{9}$/;
            const passwordPattern =
                /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

            if (firstName === "") {
                document.getElementById("firstNameError").innerText = "First name is required";
                valid = false;
            }

            if (lastName === "") {
                document.getElementById("lastNameError").innerText = "Last name is required";
                valid = false;
            }

            if (age === "" || age <= 0) {
                document.getElementById("ageError").innerText = "Enter valid age";
                valid = false;
            }

            if (!gender) {
                document.getElementById("genderError").innerText = "Select gender";
                valid = false;
            }

            if (!phonePattern.test(phone)) {
                document.getElementById("phoneError").innerText =
                    "Mobile number must start with 6-9 and be 10 digits";
                valid = false;
            }

            if (email === "") {
                document.getElementById("emailError").innerText = "Email is required";
                valid = false;
            }

            if (!passwordPattern.test(password)) {
                document.getElementById("passwordError").innerText =
                    "Password must contain uppercase, lowercase, number & special character";
                valid = false;
            }

            if (password !== confirmPassword) {
                document.getElementById("confirmPasswordError").innerText =
                    "Passwords do not match";
                valid = false;
            }

            return valid;
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
                       <form action="signUp"
                             method="post"
                             onsubmit="return validateForm()">


                           <div class="mb-2">
                               <label>First Name</label>
                               <input type="text" id="firstName" name="firstName"
                                      class="form-control" onblur="return validateForm()" required>
                               <div id="firstNameError" class="error" onblur="return validateForm()"></div>
                           </div>

                           <div class="mb-2">
                               <label>Last Name</label>
                               <input type="text" id="lastName" name="lastName"
                                      class="form-control" onblur="return validateForm()" required>
                               <div id="lastNameError" class="error"></div>
                           </div>

                           <div class="mb-2">
                               <label>Age</label>
                               <input type="number" id="age" name="age"
                                      class="form-control" min="1" onblur="return validateForm()" required>
                               <div id="ageError" class="error"></div>
                           </div>

                           <div class="mb-2">
                               <label>Gender</label><br>
                               <input type="radio" name="gender" value="Male" onblur="return validateForm()" required> Male
                               <input type="radio" name="gender" value="Female" onblur="return validateForm()" class="ms-3"> Female
                               <div id="genderError" class="error"></div>
                           </div>

                           <div class="mb-2">
                               <label>Mobile Number</label>
                               <input type="text" id="phoneNo" name="phoneNo"
                                      class="form-control" maxlength="10" onblur="return validateForm()" required>
                               <div id="phoneError" class="error"></div>
                           </div>

                           <div class="mb-2">
                               <label>Email</label>
                               <input type="email" id="email" name="email"
                                      class="form-control" onblur="return validateForm()" required>
                               <div id="emailError" class="error"></div>
                           </div>

                           <div class="mb-2">
                               <label>Password</label>
                               <input type="password" id="password" name="password"
                                      class="form-control" onblur="return validateForm()" required>
                               <div id="passwordError" class="error"></div>
                           </div>

                           <div class="mb-3">
                               <label>Confirm Password</label>
                               <input type="password" id="confirmPassword" name="confirmPassword"
                                      class="form-control" onblur="return validateForm()" required>
                               <div id="confirmPasswordError" class="error"></div>
                           </div>


                            <div class="d-grid">
                                <button class="btn btn-warning btn-lg">
                                    Register
                                </button>
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
