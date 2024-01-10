# Patient Registration System

The Patient Registration System is a web application that allows administrators to register patients and manage their records securely. The system incorporates user authentication and authorization features and uses JSP, Servlets, and MySQL for effective data handling.

## Features

- **Admin Panel:** Register new patients and manage the patient list.
- **User Authentication:** Secure login system for administrators.
- **Authorization:** Differentiate between admin and regular user roles.
- **MySQL Database:** Persistent storage for patient records.

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Servlets
- MySQL

## Setup

1. **Database Setup:**
   - Create a MySQL database and run the provided `schema.sql` script to set up the necessary tables.

2. **Project Configuration:**
   - Open the project in your preferred IDE.
   - Configure your database connection in the `db.properties` file.

3. **Run the Application:**
   - Deploy the application on a servlet container (e.g., Apache Tomcat).
   - Access the application via `http://localhost:8080/PatientRegistrationSystem`.

## Usage

1. **Admin Registration:**
   - Visit the registration page and sign up as an admin.

2. **Login:**
   - Use your admin credentials to log in.

3. **Patient Registration:**
   - Navigate to the admin panel to register new patients.

4. **View Patient List:**
   - Admins can view the list of registered patients.
