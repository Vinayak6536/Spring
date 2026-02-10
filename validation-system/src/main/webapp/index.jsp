<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Person Registration</title>
    <style>
        label {
            display: inline-block;
            width: 120px;
        }
    </style>
</head>
<body>

<h2>Person Registration Form</h2>

<form action="save" method="post">

    <label>First Name:</label>
    <input type="text" name="firstName"><br><br>
    ${firstNameError}<br>

    <label>Last Name:</label>
    <input type="text" name="lastName"><br><br>
${lastNameError}<br><br>

    <label>Age:</label>
    <input type="number" name="age"><br><br>${ageError}<br><br>

    <label>Address:</label>
    <input type="text" name="address"><br><br>${addressError}<br><br>

    <label>Aadhar No:</label>
    <input type="number" name="adharNo"><br><br>${adharNoError}<br><br>

    <label>State:</label>
    <input type="text" name="state"><br><br>${stateError}<br><br>

    <label>Country:</label>
    <input type="text" name="country"><br><br>${countryError}<br><br>

    <input type="submit" value="Save">

</form>

</body>
</html>
