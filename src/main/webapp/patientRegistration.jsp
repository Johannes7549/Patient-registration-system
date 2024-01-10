<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
   <link rel="stylesheet" href="patientregistration.css">
</head>
<body>
	<h1>Here is a patient registration form</h1>
	<h3>Fill all the required information correctly</h3>
    <form action="PatientRegistrationServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age"><br>
        <label for="gender">Gender:</label><br>
        <input type="text" id="gender" name="gender"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="phone">Phone:</label><br>
        <input type="text" id="phone" name="phone"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>