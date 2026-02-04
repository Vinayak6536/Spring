<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Batch</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

    <style>
        html, body { height: 100%; }

        body {
            background-color: #f4f6f9;
            display: flex;
            flex-direction: column;
        }

        .nav-link-custom {
            color: white;
            margin-right: 25px;
            cursor: pointer;
        }

        .nav-link-custom:hover {
            text-decoration: underline;
        }

        .admin-icon {
            border-radius: 50%;
            border: 2px solid #ffc107;
            padding: 4px;
        }

        .admin-hover {
            position: relative;
            cursor: pointer;
        }

        .admin-hover-card {
            display: none;
            position: absolute;
            right: 0;
            top: 55px;
            width: 240px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.2);
            z-index: 1000;
        }

        .admin-hover:hover .admin-hover-card {
            display: block;
        }

        .dashboard-card {
            border-radius: 22px;
            background: linear-gradient(135deg, #ffffff, #f1f4f9);
            box-shadow: 0 14px 30px rgba(0,0,0,0.15);
        }

        .dashboard-header {
            padding: 18px;
            font-size: 20px;
            font-weight: 700;
            color: white;
            text-align: center;
            border-radius: 22px 22px 0 0;
            background: linear-gradient(135deg, #003366, #007bff);
        }

.error {
    color: #dc3545;          /* Bootstrap danger red */
    font-size: 0.85rem;
    margin-top: 4px;
    display: block;
}
        footer {
            background: #212529;
            color: white;
        }
    </style>

    <script>
    /* ===== Batch Name ===== */
    function validateBatchName() {
        const input = document.getElementById("batchName");
        const error = document.getElementById("batchNameError");

        if (input.value.trim().length < 3) {
            error.innerText = "Batch name must be at least 3 characters";
            input.classList.add("error-input");
            input.classList.remove("success-input");
            return false;
        }

        error.innerText = "";
        input.classList.remove("error-input");
        input.classList.add("success-input");
        return true;
    }

    /* ===== Start Date ===== */
    function validateBatchStartDate() {
        const input = document.getElementById("batchStartDate");
        const error = document.getElementById("batchStartDateError");

        if (!input.value) {
            error.innerText = "Start date is required";
            input.classList.add("error-input");
            input.classList.remove("success-input");
            return false;
        }

        error.innerText = "";
        input.classList.remove("error-input");
        input.classList.add("success-input");
        return true;
    }

    /* ===== End Date ===== */
    function validateBatchEndDate() {
        const startDate = document.getElementById("batchStartDate").value;
        const endInput = document.getElementById("batchEndDate");
        const error = document.getElementById("batchEndDateError");

        if (!endInput.value) {
            error.innerText = "End date is required";
            endInput.classList.add("error-input");
            endInput.classList.remove("success-input");
            return false;
        }

        if (startDate && endInput.value < startDate) {
            error.innerText = "End date cannot be before start date";
            endInput.classList.add("error-input");
            endInput.classList.remove("success-input");
            return false;
        }

        error.innerText = "";
        endInput.classList.remove("error-input");
        endInput.classList.add("success-input");
        return true;
    }

    /* ===== Trainer Name ===== */
    function validateBatchTrainer() {
        const input = document.getElementById("batchTrainer");
        const error = document.getElementById("batchTrainerError");

        if (input.value.trim().length < 3) {
            error.innerText = "Trainer name must be at least 3 characters";
            input.classList.add("error-input");
            input.classList.remove("success-input");
            return false;
        }

        error.innerText = "";
        input.classList.remove("error-input");
        input.classList.add("success-input");
        return true;
    }

    /* ===== Validate Entire Form (on submit) ===== */
    function validateBatchForm() {
        const isValid =
            validateBatchName() &
            validateBatchStartDate() &
            validateBatchEndDate() &
            validateBatchTrainer();

        return !!isValid;
    }
    </script>

</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container d-flex align-items-center">

        <a href="adminDashboard">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="d-flex align-items-center ms-4 gap-4">
            <span class="nav-link-custom" onclick="showSection('about')">About</span>
            <span class="nav-link-custom" onclick="showSection('fields')">Fields</span>
            <span class="nav-link-custom" onclick="showSection('contact')">Contact</span>
        </div>

        <!-- ADMIN INFO -->
        <div class="ms-auto admin-hover">
            <div class="d-flex align-items-center text-white">
                <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                     height="40" class="admin-icon me-2">

                <!-- 🔴 FIXED: use correct admin field -->
                <span class="fw-semibold">Admin</span>
            </div>

            <div class="admin-hover-card p-3 text-center">
                <h6 class="fw-bold mb-1">${admin.getFirstName()}</h6>
                <p class="text-muted mb-3">${admin.getEmail()}</p>
                <a href="logout" class="btn btn-danger btn-sm w-100">Logout</a>
            </div>
        </div>

    </div>
</nav>

<!-- ================= ADD BATCH FORM ================= -->
<div class="container my-5 flex-grow-1">
    <div class="row justify-content-center">
        <div class="col-md-7">

            <form action="addBatch"
                  method="post"

                  class="dashboard-card"
                  accept-charset="UTF-8">

                <div class="dashboard-header">
                    Add Batch
                </div>

                <div class="p-4">

                    <!-- Batch Name -->
                    <div class="mb-2">
                        <label>Batch Name</label>
                        <input type="text"
                               id="batchName"
                               name="batchName"
                               class="form-control"
                               value="${batch.batchName}"
                               oninput="validateBatchName()"
                               required>
                        <div id="batchNameError" class="error">
                            ${batchNameError}
                        </div>
                    </div>

                    <!-- Start Date -->
                    <div class="mb-2">
                        <label>Start Date</label>
                        <input type="date"
                               id="batchStartDate"
                               name="batchStartDate"
                               class="form-control"
                               value="${batch.batchStartDate}"
                               oninput="validateBatchStartDate()"
                               required>
                        <div id="batchStartDateError" class="error">
                            ${batchStartDateError}
                        </div>
                    </div>

                    <!-- End Date -->
                    <div class="mb-2">
                        <label>End Date</label>
                        <input type="date"
                               id="batchEndDate"
                               name="batchEndDate"
                               class="form-control"
                               value="${batch.batchEndDate}"
                               oninput="validateBatchEndDate()"
                               required>
                        <div id="batchEndDateError" class="error">
                            ${batchEndDateError}
                        </div>
                    </div>

                    <!-- Trainer Name -->
                    <div class="mb-2">
                        <label>Trainer Name</label>
                        <input type="text"
                               id="batchTrainer"
                               name="batchTrainer"
                               class="form-control"
                               value="${batch.batchTrainer}"
                               oninput="validateBatchTrainer()"
                               required>
                        <div id="batchTrainerError" class="error">
                            ${batchTrainerError}
                        </div>
                    </div>

                    <!-- 🔴 FILE UPLOAD (MATCHES BatchDto.file)
                    <div class="mb-4">
                        <label class="form-label">Batch Logo</label>
                        <input type="file"
                               name="file"
                               class="form-control"
                               accept="image/*">
                    </div> -->

                    <!-- Buttons -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-success me-2">
                            <i class="bi bi-save"></i> Save Batch
                        </button>

                        <a href="adminPage.jsp" class="btn btn-secondary">
                            <i class="bi bi-arrow-left"></i> Back
                        </a>
                    </div>

                </div>
            </form>

        </div>
    </div>
</div>

<footer class="text-center py-3 mt-auto">
    © 2026 My Application
</footer>

<!-- ================= SAME SCRIPT ================= -->
<script>
    function showSection(sectionId) {
        document.querySelectorAll('.page-section')
            .forEach(sec => sec.style.display = 'none');
        document.getElementById(sectionId).style.display = 'block';
    }
</script>

</body>
</html>
