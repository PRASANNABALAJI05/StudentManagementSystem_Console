# 🎓 Student Management System (Console-Based)

A simple and efficient **Student Management System** built using **Java** (console-based). This project allows administrators to add, view, and delete student records. It also persists data using file handling and ensures only registered admins can perform operations.

---

## 🚀 Features

- 🔐 **Admin Authentication**  
  Only predefined admins with passwords can access and modify student data.

- 📝 **Add Student Details**  
  Capture and validate:
  - Name
  - Register Number
  - Date of Birth (DOB)
  - GPA (for 8 semesters)
  - Mail ID
  - Contact Number

- 📋 **Display Student Records**  
  View all saved student details in a clean format.

- 🔍 **Search Student by Register Number**  
  Quickly find a student’s complete information using their Reg No.

- ❌ **Delete Student Record by Reg No**  
  Remove specific student data safely and permanently from the file.

- 💾 **Data Persistence (File Handling)**  
  Student details are saved to a file and automatically loaded on program start.

- ♻️ **Looped Menu for Multiple Operations**  
  Perform operations continuously until you choose to exit.

- ⚙️ **Menu Options using Constants/Enum**  
  Cleaner code using enums/constants instead of magic numbers or strings.

---

## 📁 File Structure

```
StudentManagementSystem_Console/
├── src/
│   ├── Admin.java              # Stores admin credentials
│   ├── Student.java            # Student model class
│   ├── StudentManager.java     # Core logic to add/view/delete/search students
│   ├── StoreDetails.java       # Handles file read/write
│   └── Main.java               # Entry point with looped menu
├── Students Data.txt           # Saved student records
├── README.md                   # Project documentation
└── .gitignore                  # Git ignore rules (optional)
```

---

## 🛠 Technologies Used

- **Language**: Java  
- **IDE**: IntelliJ IDEA  
- **Java Version**: Java 8+  
- **File Handling**: Used to store and load student data

---

## 🧪 Sample Admins

These are the predefined admins in the `Admin.java` file:

```java
admins.put("admin1", "password123");
admins.put("prasanna", "zoho2027");
```

---

## 🧑‍💻 How to Run

1. **Clone the Repository**

```bash
git clone https://github.com/PRASANNABALAJI05/StudentManagementSystem_Console.git
cd StudentManagementSystem_Console
```

2. **Open in IntelliJ IDEA**
   - Open the project folder
   - Make sure Java SDK is configured

3. **Run `Main.java`**

   - Right-click `Main.java` → Run
   - Or use terminal:
     ```bash
     javac Main.java
     java Main
     ```

---

## 🧹 Future Enhancements

- GUI version using JavaFX or Swing
- Admin registration system (instead of hardcoded values)
- Student update/edit option
- Search by name or contact
- Export to CSV or JSON

---

## 🙌 Author

**Prasanna Balaji**  
🧑‍🎓 ECE, Saveetha Engineering College  
💼 Aspiring Software Developer  
📌 Focused on Java, DSA, and building clean backend systems  
🔗 [GitHub Profile](https://github.com/PRASANNABALAJI05)

---
