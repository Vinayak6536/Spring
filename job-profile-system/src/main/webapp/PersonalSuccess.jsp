<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
        <div class="col-md-6">

            <div class="card shadow text-center">
                <div class="card-header bg-success text-white">
                    <h5>Success</h5>
                </div>

                <div class="card-body">
                    <h4 class="text-success mb-3">
                        ✅ Data Saved Successfully
                    </h4>


                    <p class="text-muted">
                        Personal details saved for
                        <strong>
                            <a href="getPhone?phone=${firstName.getPhone()}">
                                ${firstName.getFirstName()}
                            </a>
                        </strong>
                    </p>

<a href="getId?id=${dtos.getId()}"
   class="btn btn-primary px-4 ${enableNext ? '' : 'disabled'}"
   style="${enableNext ? '' : 'pointer-events:none;'}">
    Next
</a>


                </div>
            </div>

        </div>
    </div>
</div>

</body>
<script>
    function enableNextButton() {
        const btn = document.getElementById("nextBtn");
        btn.classList.remove("disabled");
        btn.style.pointerEvents = "auto";
    }
</script>
</html>
