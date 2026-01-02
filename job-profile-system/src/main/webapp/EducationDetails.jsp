<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Education Details</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function showCollege(button) {
            document.getElementById("collegeSection").style.display = "block";
            button.style.display = "none";
        }

        function showDegree(button) {
            document.getElementById("degreeSection").style.display = "block";
            button.style.display = "none";
        }

        function showMaster(button) {
            document.getElementById("masterSection").style.display = "block";
            button.style.display = "none";
        }

        function validateForm() {
            // School validation
            var schoolName = document.forms["eduForm"]["schoolName"].value;
            var schoolPerc = document.forms["eduForm"]["schoolPerc"].value;
            if (schoolName == "" || schoolName.length > 100) {
                alert("Please enter a valid School Name (max 100 chars).");
                return false;
            }
            if (schoolPerc == "" || schoolPerc < 0 || schoolPerc > 100) {
                alert("Please enter a valid School Percentage (0-100).");
                return false;
            }

            // College validation (if visible)
            var collegeSection = document.getElementById("collegeSection");
            if (collegeSection.style.display == "block") {
                var collegeName = document.forms["eduForm"]["collegeName"].value;
                var collegePerc = document.forms["eduForm"]["collegePerc"].value;
                if (collegeName == "" || collegeName.length > 100) {
                    alert("Please enter a valid College Name (max 100 chars).");
                    return false;
                }
                if (collegePerc == "" || collegePerc < 0 || collegePerc > 100) {
                    alert("Please enter a valid College Percentage (0-100).");
                    return false;
                }
            }

            // Degree validation (if visible)
            var degreeSection = document.getElementById("degreeSection");
            if (degreeSection.style.display == "block") {
                var degreeName = document.forms["eduForm"]["degreeName"].value;
                var degreePerc = document.forms["eduForm"]["degreePerc"].value;
                if (degreeName == "" || degreeName.length > 100) {
                    alert("Please enter a valid Degree Name (max 100 chars).");
                    return false;
                }
                if (degreePerc == "" || degreePerc < 0 || degreePerc > 100) {
                    alert("Please enter a valid Degree Percentage (0-100).");
                    return false;
                }
            }

            // Master validation (if visible)
            var masterSection = document.getElementById("masterSection");
            if (masterSection.style.display == "block") {
                var masterName = document.forms["eduForm"]["masterName"].value;
                var masterPerc = document.forms["eduForm"]["masterPerc"].value;
                if (masterName == "" || masterName.length > 100) {
                    alert("Please enter a valid Master Course Name (max 100 chars).");
                    return false;
                }
                if (masterPerc == "" || masterPerc < 0 || masterPerc > 100) {
                    alert("Please enter a valid Master Percentage (0-100).");
                    return false;
                }
            }

            return true; // All validations passed
        }
    </script>
</head>

<body class="bg-light">
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Job Profile</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="PersonalDetails.jsp">Personal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="EducationDetails.jsp">Education</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Experience.jsp">Experience</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Contact.jsp">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class
                <div class="card-header bg-success text-white text-center">
                    <h5>Education Details</h5>
                </div>

                <div class="card-body">
                    <form name="eduForm" action="<%= request.getContextPath() %>/education" method="post" onsubmit="return validateForm()">

                            <div class="col-md-8">
                                <input type="number" name="id" class="form-control" value="${dto.getId()}" maxlength="100" required>
                            </div>
                        <!-- School -->
                        <h6>School</h6>
                        <div class="row mb-3">
                            <div class="col-md-8">
                                <input type="text" name="schoolName" class="form-control" placeholder="School Name" maxlength="100" required>
                            </div>
                            <div class="col-md-4">
                                <input type="number" name="schoolPerc" class="form-control" placeholder="Percentage" min="0" max="100" step="0.01" required>
                            </div>
                        </div>

                        <!-- Add College Button -->
                        <button type="button" class="btn btn-outline-primary mb-3" onclick="showCollege(this)">+ Add College</button>

                        <!-- College Section (Hidden) -->
                        <div id="collegeSection" style="display:none;">
                            <h6>College</h6>
                            <div class="row mb-3">
                                <div class="col-md-8">
                                    <input type="text" name="collegeName" class="form-control" placeholder="College Name" maxlength="100">
                                </div>
                                <div class="col-md-4">
                                    <input type="number" name="collegePerc" class="form-control" placeholder="Percentage" min="0" max="100" step="0.01">
                                </div>
                            </div>

                            <!-- Add Degree Button -->
                            <button type="button" class="btn btn-outline-secondary mb-3" onclick="showDegree(this)">+ Add Degree</button>
                        </div>

                        <!-- Degree Section (Hidden) -->
                        <div id="degreeSection" style="display:none;">
                            <h6>Degree</h6>
                            <div class="row mb-3">
                                <div class="col-md-8">
                                    <input type="text" name="degreeName" class="form-control" placeholder="Degree Name" maxlength="100">
                                </div>
                                <div class="col-md-4">
                                    <input type="number" name="degreePerc" class="form-control" placeholder="Percentage" min="0" max="100" step="0.01">
                                </div>
                            </div>

                            <!-- Add Master Button -->
                            <button type="button" class="btn btn-outline-dark mb-3" onclick="showMaster(this)">+ Add Master</button>
                        </div>

                        <!-- Master Section (Hidden) -->
                        <div id="masterSection" style="display:none;">
                            <h6>Master</h6>
                            <div class="row mb-3">
                                <div class="col-md-8">
                                    <input type="text" name="masterName" class="form-control" placeholder="Master Course Name" maxlength="100">
                                </div>
                                <div class="col-md-4">
                                    <input type="number" name="masterPerc" class="form-control" placeholder="Percentage" min="0" max="100" step="0.01">
                                </div>
                            </div>
                        </div>

                        <div class="text-center">
                            <a href="idDirect?id=${dto.id}" class="btn btn-success">Next</a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
