<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create My Account</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">American Red Cross</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Donate Blood</a></li>
                <li class="nav-item"><a class="nav-link active" href="#">Create Account</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- FORM CONTAINER -->
<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-danger text-white text-center">
                    <h4>Create My Account</h4>
                </div>

                <div class="card-body">
                    <form action="createAccount" method="post">

                        <!-- Donor ID -->
                        <div class="mb-3">
                            <label class="form-label">Donor ID (Optional)</label>
                            <input type="text" class="form-control" name="donorId">
                        </div>

                        <!-- First Name -->
                        <div class="mb-3">
                            <label class="form-label">First Name *</label>
                            <input type="text" class="form-control" name="firstName" required>
                        </div>

                        <!-- Last Name -->
                        <div class="mb-3">
                            <label class="form-label">Last Name *</label>
                            <input type="text" class="form-control" name="lastName" required>
                        </div>

                        <!-- Date of Birth -->
                        <div class="mb-3">
                            <label class="form-label">Date of Birth *</label>
                            <input type="date" class="form-control" name="dob" required>
                        </div>

                        <!-- ZIP Code -->
                        <div class="mb-3">
                            <label class="form-label">ZIP Code *</label>
                            <input type="text" class="form-control" name="zipCode" required>
                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label class="form-label">Email Address *</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>

                        <!-- Phone -->
                        <div class="mb-3">
                            <label class="form-label">Mobile Number *</label>
                            <input type="tel" class="form-control" name="phone" required>
                        </div>

                        <!-- Password -->
                        <div class="mb-3">
                            <label class="form-label">Password *</label>
                            <input type="password" class="form-control" name="password" required>
                        </div>

                        <!-- Confirm Password -->
                        <div class="mb-3">
                            <label class="form-label">Confirm Password *</label>
                            <input type="password" class="form-control" name="confirmPassword" required>
                        </div>

                        <!-- Terms -->
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" required>
                            <label class="form-check-label">
                                I agree to the Terms & Conditions
                            </label>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-danger">
                                Create Account
                            </button>
                        </div>

                    </form>
                </div>

                <div class="card-footer text-center">
                    Already have an account?
                    <a href="login.jsp" class="text-danger fw-bold">Login</a>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
