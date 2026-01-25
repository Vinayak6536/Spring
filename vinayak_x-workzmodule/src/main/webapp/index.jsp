<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Xworkz Module</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
        }
        .content {
            flex: 1;
        }
        footer {
            background-color: #212529;
            color: white;
        }

        .profile-dropdown {
            position: relative;
            cursor: pointer;
        }

        .profile-dropdown img {
            border: 2px solid white;
        }

        .dropdown-menu-custom {
            display: none;
            position: absolute;
            right: 0;
            top: 50px;
            background: white;
            min-width: 180px;
            border-radius: 6px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.3);
            z-index: 1000;
        }

        .dropdown-menu-custom a {
            display: block;
            padding: 10px;
            color: black;
            text-decoration: none;
            font-size: 14px;
        }

        .dropdown-menu-custom a:hover {
            background-color: #f1f1f1;
        }

        .profile-dropdown:hover .dropdown-menu-custom {
            display: block;
        }

    </style>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container">

        <a href="index.jsp">
            <img src="<%= request.getContextPath() %>/resources/static/Logo.png" height="40">
        </a>

        <div class="ms-auto d-flex align-items-center">

            <!-- Profile Hover -->
            <div class="profile-dropdown">
                <img src="<%= request.getContextPath() %>/resources/static/admin.png"
                     height="40"
                     class="rounded-circle"
                     alt="Profile">

                <div class="dropdown-menu-custom">
                    <a href="Profile.jsp">View Profile</a>
                    <a href="EditProfile.jsp">Edit Profile</a>
                    <a href="ChangePassword.jsp">Change Password</a>
                    <hr>
                    <a href="SignOut.jsp" class="text-danger">Logout</a>
                </div>
            </div>

        </div>
    </div>
</nav>



<div class="content d-flex align-items-center">
    <div class="container text-center">
        <h6 class="text-uppercase text-muted">We Are</h6>

        <h1 class="fw-bold mt-2">Experienced Trainers</h1>

        <div class="fs-1 fw-bold text-warning">_</div>

        <p class="mt-3">
            <a href="SignUp.jsp" class="text-decoration-none fw-semibold">
                Click here for registration
            </a>
        </p>

        <a href="#" class="btn btn-warning btn-lg mt-2">
            Enroll Now
        </a>

        <h5 class="mt-4 fw-semibold">Coding</h5>
    </div>
</div>

<footer class="text-center py-3">
    © 2026 My Application. All rights reserved.
</footer>

</body>
</html>
