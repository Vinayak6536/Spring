<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Theatre</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
        }
        main {
            flex: 1;
        }
    </style>
</head>

<body class="bg-light">

<jsp:include page="navbar.jsp"/>

<main>
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h4>Add Theatre</h4>
        </div>

        <div class="card-body">
            <form action="addTheatre" method="post">

                <div class="mb-3">
                    <label class="form-label">Theatre Name</label>
                    <input type="text" class="form-control" name="theatreName" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Location</label>
                    <input type="text" class="form-control" name="location" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">City</label>
                    <input type="text" class="form-control" name="city" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Total Screens</label>
                    <input type="number" class="form-control" name="totalScreens" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Total Seats</label>
                    <input type="number" class="form-control" name="totalSeats" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Owner Name</label>
                    <input type="text" class="form-control" name="ownerName" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">AC Available</label>
                    <select class="form-select" name="acAvailable">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Ticket Price</label>
                    <input type="number" step="0.01" class="form-control" name="ticketPrice" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Contact Number</label>
                    <input type="text" class="form-control" name="contactNumber" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Save Theatre</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                </div>

            </form>
        </div>
    </div>
</div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="theatre.js"></script>

</body>
</html>
