<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Experience Details</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function toggleExperience(value) {
            if (value === 'yes') {
                document.getElementById("experienceSection").style.display = "block";
            } else {
                document.getElementById("experienceSection").style.display = "none";
            }
        }
    </script>
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h5>Experience Details</h5>
                </div>

                <div class="card-body">
                    <form action="experience" method="post">

                        <!-- Experience Radio -->
                        <label class="form-label fw-bold">Do you have experience?</label>
                        <div class="mb-3">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio"
                                       name="hasExperience" value="yes"
                                       onclick="toggleExperience('yes')">
                                <label class="form-check-label">Yes</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio"
                                       name="hasExperience" value="no"
                                       onclick="toggleExperience('no')" checked>
                                <label class="form-check-label">No</label>
                            </div>
                        </div>

                        <!-- Experience Section (Hidden by Default) -->
                        <div id="experienceSection" style="display:none;">

                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <input type="text" class="form-control"
                                           name="companyName" placeholder="Company Name">
                                </div>

                                <div class="col-md-6">
                                    <input type="text" class="form-control"
                                           name="role" placeholder="Role / Designation">
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <input type="number" class="form-control"
                                           name="experienceYears" placeholder="Years of Experience">
                                </div>
                            </div>

                        <!-- Buttons -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-success">Next</button>
                        </div>

                    </form>
                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>
