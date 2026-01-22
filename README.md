# 🏦 Banking Application

A secure and scalable **Banking Application** developed using **Java** and **MySQL**, following **Agile methodology**.  
The application provides user authentication, admin management, and secure data storage.

---

## 📌 Project Overview

The Banking Application is designed to simulate basic banking system functionality.  
It allows users to **register and log in using personal details such as phone number and Aadhaar number**, while all data is securely stored in a **MySQL database**.

An **Admin module** is implemented to manage and monitor all registered users.

---

## 🚀 Features

### 👤 User Features
- User Registration (Signup)
- Secure Login Authentication
- Phone Number Validation
- Aadhaar Number Registration
- Database-backed user profile

### 🛡️ Admin Features
- Admin Login
- View all registered users
- Manage user records
- Secure admin authentication

### 🔐 Security
- Role-based access (User/Admin)
- Database validation
- Secure credential handling

---

## 🧰 Technologies Used

| Technology | Description |
|----------|------------|
| Java | Core backend logic |
| JDBC | Database connectivity |
| MySQL | Data storage |
| HTML/CSS | Frontend (if applicable) |
| Eclipse / IntelliJ | IDE |
| Git & GitHub | Version control |

---

## 📂 Project Structure

Banking-Application/
│
├── src/
│ ├── com.bank.controller/
│ ├── com.bank.model/
│ ├── com.bank.dao/
│ └── com.bank.util/
│
├── database/
│ └── banking_db.sql
│
├── README.md
├── LICENSE
└── pom.xml (if Maven project)


---

## 🗄️ Database Design

### User Table
- user_id (Primary Key)
- name
- phone_number
- aadhaar_number
- username
- password

### Admin Table
- admin_id
- username
- password

---

## ▶️ How to Run the Project

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- IDE (Eclipse / IntelliJ / VS Code)
- MySQL JDBC Connector

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/banking-application.git
Import the project into your IDE.

Create the database:

CREATE DATABASE banking_db;
Import the SQL file:

SOURCE banking_db.sql;
Update database credentials in:

com.bank.util.DBConnection.java
Run the application from the main class or server.

🔄 Agile Methodology
The project follows Agile development, enabling:

Iterative development

Continuous testing

Incremental feature delivery

Faster feedback and improvement

Sprint Highlights
Sprint 1: Project setup & database design

Sprint 2: User login & signup

Sprint 3: Aadhaar & phone validation

Sprint 4: Admin module

Sprint 5: Testing & optimization

🧪 Testing
Login and signup validation

Database connectivity testing

Admin access testing

Input validation testing

📜 License
This project is licensed under the MIT License.

MIT License allows free use, modification, and distribution of this software.
See the LICENSE file for more details.

📌 Conclusion
This Banking Application demonstrates a secure, modular, and database-driven system developed using Java and MySQL.
It is suitable for academic projects, learning purposes, and backend development practice.

👨‍💻 Author
