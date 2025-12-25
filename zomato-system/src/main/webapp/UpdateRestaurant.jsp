<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Registration</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Zomato</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ZomatoForm.jsp">Add Restaurant</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="Search.jsp">Search</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="text-center mb-4">Restaurant Registration Form</h3>

        <form action="<%= request.getContextPath() %>/update" method="post" id="restaurantForm" onsubmit="return validateForm()">

            <div class="mb-3">
                <label class="form-label">Restaurant Name</label>
                <input type="text" class="form-control" name="name" value="${name.getName()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Owner Name</label>
                <input type="text" class="form-control" name="ownerName" value="${name.getOwnerName()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Owner Age</label>
                <input type="number" class="form-control" name="ownerAge" min="18" value="${name.getOwnerAge()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Restaurant Phone No</label>
                <input type="number" class="form-control" name="phoneNo" id="phoneNo" value="${name.getPhoneNo()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Branch</label>
                <input type="text" class="form-control" name="branch" value="${name.getBranch()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" name="address" value="${name.getAddress()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Pincode</label>
                <input type="number" class="form-control" name="pincode" id="pincode" value="${name.getPincode()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">City</label>
                <input type="text" class="form-control" name="city" value="${name.getCity()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">State</label>
                <input type="text" class="form-control" name="state" value="${name.getState()}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Country</label>
                <input type="text" class="form-control" name="country" value="${name.getCountry()}">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Update</button>
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
