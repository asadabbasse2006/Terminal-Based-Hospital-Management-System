# Terminal-Based Hospital Management System

A simple **console-based Hospital Management System** developed in **Java** with **MySQL integration** using **JDBC**. The system provides a menu-driven interface to manage hospital data including doctors, patients, and staff.

---

## 📖 Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [SQL Schema](#sql-schema)
- [Example Commands](#example-commands)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

---

## 🚀 Features
- Add new doctors, patients, or staff  
- View all records  
- Search records by ID  
- Update existing information  
- Delete records  
- Persistent storage with **MySQL database**  

---

## 🛠 Technologies Used
- **Java**  
- **MySQL**  
- **JDBC (Java Database Connectivity)**  
- IDE: IntelliJ IDEA / VS Code  

---

## ⚙️ Installation
1. Clone this repository:  
   ```bash
   git clone https://github.com/asadabbasse2006/Terminal-Based-Hospital-Management-System.git
   cd Terminal-Based-Hospital-Management-System
   ```
2. Set up a MySQL database (see [Database Setup](#database-setup)).  
3. Configure database credentials inside `DBConnection.java`.  
4. Compile and run the project:  
   ```bash
   javac *.java
   java Main
   ```

---

## 🗄 Database Setup
1. Open MySQL and create a database:  
   ```sql
   CREATE DATABASE hospital_management;
   ```
2. Switch to the new database:  
   ```sql
   USE hospital_management;
   ```
3. Create tables using the schema below.  

---

## 🗂 SQL Schema
```sql
-- Doctors table
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(100)
);

-- Patients table
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(10),
    phone VARCHAR(15),
    address VARCHAR(255)
);

-- Staff table
CREATE TABLE staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100)
);
```

---

## ▶️ Usage
Run the application from the terminal:
```bash
java Main
```
You’ll be presented with a **menu-driven interface** to perform operations like adding, searching, updating, and deleting records.

---

## 💡 Example Commands
- Add a doctor → enter option `1` from the main menu and provide details.  
- View all patients → select the patients menu, then choose “View all”.  
- Delete staff record → enter staff ID when prompted.  

---

## 🐞 Troubleshooting
- **Database connection failed** → Check MySQL server is running and credentials in `DBConnection.java` are correct.  
- **Tables not found** → Ensure you’ve created the required tables before running the program.  
- **Compilation errors** → Ensure you’re using Java 8+ and have MySQL JDBC driver in your classpath.  

---

## 👨‍💻 Contributors
- [Asad Abbas](https://github.com/asadabbasse2006)  

---

## 📜 License
This project is licensed under the **MIT License**.  
