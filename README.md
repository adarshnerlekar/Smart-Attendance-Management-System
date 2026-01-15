# Smart-Attendance-Management-System
  Smart Attendance Management System is a job-ready backend application designed to automate and manage attendance efficiently for educational institutions. The system provides secure role-based access and accurate attendance tracking with monthly reports, ensuring reliability and scalability.

# 🟢 Smart Attendance Management System

A **role-based attendance management system** built using **Java Spring Boot**, **Spring Security**, and **Spring Data JPA**.  
This system simplifies attendance tracking for schools, colleges, and organizations by providing secure authentication, dashboards, and automated reporting.

---

## 💡 Project Overview

The Smart Attendance Management System helps institutions manage and track attendance efficiently.  
With **role-based access**, **JWT authentication**, and **monthly reports**, it ensures transparency, security, and accuracy in attendance tracking.  

**Key Users:**
- **Admin** – Manages all users, attendance data, and reports.
- **Teacher** – Marks student attendance and views class reports.
- **Student** – Views personal attendance status and reports.

---

## 🚀 Key Features

- 🔐 **Secure Authentication & Authorization**:  
  Uses **Spring Security** and **JWT tokens** for role-based access.

- 🧑‍🏫 **Role-Based Access Control**:  
  Admin, Teacher, and Student have specific access rights.

- 📝 **Attendance Management**:  
  Teachers can mark attendance; Admins can manage all records.

- 📊 **Monthly Reports**:  
  Auto-calculates student attendance percentage for performance tracking.

- 💾 **Database Integration**:  
  MySQL with **Spring Data JPA** for seamless CRUD operations.

- 🔄 **RESTful APIs**:  
  Follows a **Controller-Service-Repository** architecture for maintainable code.

- 🛠 **Tools & Frameworks**:  
  Maven, Postman, Hibernate, Spring Boot.

---

## 🏗 Technology Stack

| Layer                | Technology/Framework                 |
|----------------------|-------------------------------------|
| Backend              | Java, Spring Boot                   |
| Security             | Spring Security, JWT                |
| Persistence Layer    | Spring Data JPA, Hibernate, MySQL  |
| API                  | RESTful APIs                        |
| Tools                | Maven, Postman                      |

---

## 📂 Project Structure

src
├── main
│ ├── java
│ │ └── com.example.attendance
│ │ ├── controller # Handles API requests
│ │ ├── service # Business logic
│ │ ├── repository # Database interactions
│ │ ├── entity # Models/Entities
│ │ └── security # JWT and Spring Security config
│ └── resources
│ ├── application.properties
│ └── data.sql # Optional seed data

🏛 Architecture Diagram
+---------------------+
|      Frontend       |
| (Optional: Angular) |
+---------------------+
          |
          v
+---------------------+
|   Spring Boot APIs  |
| Controllers/Service |
+---------------------+
          |
          v
+---------------------+
|     Service Layer   |
| Business Logic      |
+---------------------+
          |
          v
+---------------------+
|    Repository Layer |
|  Spring Data JPA    |
+---------------------+
          |
          v
+---------------------+
|     MySQL Database  |
+---------------------+





