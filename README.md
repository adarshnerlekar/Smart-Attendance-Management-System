# Smart-Attendance-Management-System
A Smart Attendance Management System is a Java-based application designed to automate and simplify the process of tracking student or employee attendance. This system eliminates manual record-keeping and provides a fast, accurate, and efficient way to manage attendance data.
# 📌 Smart Attendance Management System

![Spring Boot](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate)

---

## 📖 Overview

The **Smart Attendance Management System** is a robust, role-based web application built using **Spring Boot** and **Spring Security** to automate and secure attendance workflows.

The system is designed to handle multiple user roles (**Admin, Teacher, Student**) with secure API access, efficient data management, and automated reporting features.

---

## 🚀 Key Highlights

- 🔐 Implemented **JWT-based Authentication & Authorization**
- 👥 Designed **Role-Based Access Control (RBAC)** for Admin, Teacher, and Student
- 📊 Automated **monthly attendance reports with percentage calculation**
- ⚙️ Managed complex workflows using **Spring Security Filters**
- 🛡️ Centralized exception handling using `@ControllerAdvice`
- 🗄️ Optimized database operations with **Spring Data JPA & Hibernate**
- 📈 Improved system reliability and response consistency

---

## 🧑‍💼 User Roles & Functionalities

### 👨‍💻 Admin
- Manage users (Add/Update/Delete)
- View system-wide reports
- Control access permissions

### 👨‍🏫 Teacher
- Mark student attendance
- View class attendance records
- Generate reports

### 👨‍🎓 Student
- View personal attendance
- Track attendance percentage

---

## 🛠️ Tech Stack

| Layer        | Technology                          |
|-------------|-----------------------------------|
| Backend      | Spring Boot, Spring Security      |
| Security     | JWT Authentication, RBAC          |
| ORM          | Spring Data JPA, Hibernate        |
| Database     | MySQL                             |
| Build Tool   | Maven                             |
| API Testing  | Postman                           |

---

## 🧱 System Architecture

- RESTful API-based architecture
- Layered structure:
  - Controller Layer
  - Service Layer
  - Repository Layer
- Secure endpoints using JWT filters
- Exception handling using global handlers

---

## 📂 Project Structure
src/
├── controller/
├── service/
├── repository/
├── entity/
├── security/
├── dto/
├── exception/
└── config/ 

🔐 Security Implementation
JWT Token-based authentication
Role-based endpoint protection
Custom authentication filters
Secure password encryption
Stateless session management

---


👨‍💻 Author

Adarsh Santosh Nerlekar
💻 Java Full Stack Developer



## ⚙️ Installation & Setup

### 1️⃣ Clone Repository
```bash
git clone https://github.com/your-username/smart-attendance-system.git
