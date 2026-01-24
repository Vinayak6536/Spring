<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>

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
        footer {
                    background-color: #212529;
                    color: white;
                }
    </style>

    <script>
        function disableResend(btn) {
            btn.disabled = true;
            btn.innerText = "Sending OTP...";
        }

         let countdown = 30;
            const resendBtn = document.getElementById("resendBtn");

            if (resendBtn) {
                const timer = setInterval(() => {
                    countdown--;
                    resendBtn.innerText = "Resend OTP (" + countdown + "s)";

                    if (countdown <= 0) {
                        clearInterval(timer);
                        resendBtn.disabled = false;
                        resendBtn.innerText = "Resend OTP";
                    }
                }, 1000);
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
            <div class="col-md-5">

                <div class="card shadow">
                    <div class="card-header bg-dark text-white text-center">
                        <h4>Forgot Password</h4>
                    </div>

                    <div class="card-body">

                        <form action="<%= request.getContextPath() %>/forgetPassword" method="post">

                            <!-- EMAIL / PHONE (ONLY BEFORE OTP) -->
                            <c:if test="${!otpSent}">
                                <div class="mb-3">
                                    <label>Email or Mobile Number</label>
                                    <input type="text"
                                           name="emailOrPhone"
                                           value="${emailOrPhoneno}"
                                           class="form-control"
                                           required>
                                </div>

                                <div class="d-grid mb-3">
                                    <button type="submit"
                                            name="action"
                                            value="sendOtp"
                                            class="btn btn-warning btn-lg">
                                        Send OTP
                                    </button>
                                </div>
                            </c:if>

                            <!-- OTP SECTION -->
                            <c:if test="${otpSent}">
                               <c:if test="${not empty success}">
                                   <p class="text-center fs-4 fw-bold text-uppercase text-success">
                                       ${success}
                                   </p>
                               </c:if>
                                <!-- hidden email for resend & verify -->
 <div class="mb-3">
                                    <label>Email or Mobile Number</label>
                                    <input type="text"
                                           name="emailOrPhone"
                                           value="${email}"
                                           class="form-control"
                                           required>
                                </div>
                                <div class="mb-3">
                                    <label>Enter OTP</label>
                                    <input type="text"
                                           name="otp"
                                           class="form-control"
                                           >
                                    <div class="error">${otpError}</div>
                                </div>

                                <!-- VERIFY OTP -->
                                <div class="d-grid mb-2">
                                    <button type="submit"
                                            name="action"
                                            value="verifyOtp"
                                            class="btn btn-success btn-lg"
                                            >
                                        Verify OTP
                                    </button>
                                </div>

                                <!-- RESEND OTP -->
                                <div class="d-grid mt-2">
                                        <button type="submit"
                                                id="resendBtn"
                                                name="action"
                                                value="resendOtp"
                                                class="btn btn-secondary btn-lg"
                                                disabled>
                                            Resend OTP (30s)
                                        </button>
                                    </div>

                            </c:if>
<c:if test="${not empty otpVerify}">
    <p class="text-center fs-4 fw-bold text-uppercase text-success">
        ${otpVerify}
    </p>
</c:if>
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
<script>
    window.onload = function () {
        const resendBtn = document.getElementById("resendBtn");

        if (!resendBtn) return; // button not present

        let timeLeft = 30;

        resendBtn.disabled = true;

        const timer = setInterval(() => {
            timeLeft--;
            resendBtn.innerText = "Resend OTP (" + timeLeft + "s)";

            if (timeLeft <= 0) {
                clearInterval(timer);
                resendBtn.disabled = false;
                resendBtn.innerText = "Resend OTP";
            }
        }, 1000);
    };
</script>
</html>
