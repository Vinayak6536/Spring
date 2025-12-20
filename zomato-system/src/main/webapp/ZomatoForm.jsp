<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Registration</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <a class="navbar-brand" href="#">Zomato</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ZomatoForm.jsp">Zomato Form</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="text-center mb-4">Restaurant Registration Form</h3>

        <form action="addZomato" method="post" id="restaurantForm" onsubmit="return validateForm()">

            <div class="mb-3">
                <label class="form-label">Restaurant Name</label>
                <input type="text" class="form-control" name="name" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Owner Name</label>
                <input type="text" class="form-control" name="ownerName" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Owner Age</label>
                <input type="number" class="form-control" name="ownerAge" min="18" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Restaurant Phone No</label>
                <input type="number" class="form-control" name="phoneNo" id="phoneNo" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Branch</label>
                <input type="text" class="form-control" name="branch" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" name="address" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Pincode</label>
                <input type="number" class="form-control" name="pincode" id="pincode" required>
            </div>

            <div class="mb-3">
                <label class="form-label">City</label>
                <input type="text" class="form-control" name="city" required>
            </div>

            <div class="mb-3">
                <label class="form-label">State</label>
                <input type="text" class="form-control" name="state" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Country</label>
                <input type="text" class="form-control" name="country" >
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- JavaScript Validation -->
<script>
    function validateForm() {
        let phone = document.getElementById("phoneNo").value;
        let pincode = document.getElementById("pincode").value;

        if (phone.length !== 10) {
            alert("Phone number must be 10 digits");
            return false;
        }

        if (pincode.length !== 6) {
            alert("Pincode must be 6 digits");
            return false;
        }

        alert("Form submitted successfully!");
        return true;
    }
</script>

</body>
</html>
