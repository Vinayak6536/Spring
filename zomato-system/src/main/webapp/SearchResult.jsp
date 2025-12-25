<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phone Search</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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

    <!-- RESULT DETAILS -->
    <c:if test="${not empty phone}">
        <div class="card shadow">
            <div class="card-header bg-success text-white">
                <h5 class="mb-0 text-center">Phone Details</h5>
            </div>

            <div class="card-body">
                <table class="table table-bordered table-striped">
                    <tr><th>Name</th><td>${phone.getName()}</td></tr>
                    <tr><th>Owner Name</th><td>${phone.getOwnerName()}</td></tr>
                    <tr><th>Owner Age</th><td>${phone.getOwnerAge()}</td></tr>
                    <tr><th>Phone No</th><td>${phone.getPhoneNo()}</td></tr>
                    <tr><th>Branch</th><td>${phone.getBranch()}</td></tr>
                    <tr><th>Address</th><td>${phone.getAddress()}</td></tr>
                    <tr><th>Pincode</th><td>${phone.getPincode()}</td></tr>
                    <tr><th>City</th><td>${phone.getCity()}</td></tr>
                    <tr><th>State</th><td>${phone.getState()}</td></tr>
                    <tr><th>Country</th><td>${phone.getCountry()}</td></tr>
                    <tr>
                        <td colspan="5" class="text-center">
                            <a href="editDetails/${phone.getName()}" class="btn btn-primary">
                                Edit
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </c:if>

</div>

</body>
</html>
