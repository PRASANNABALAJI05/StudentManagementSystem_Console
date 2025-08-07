import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentManager {
    ArrayList<Student> studentList = new ArrayList<>();
//Add students
    public String addStudents(){
        Scanner sc = new Scanner(System.in);
        //Name
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        //Regno
        System.out.print("Enter Reg no: ");
        String regno = sc.next();
        for (Student s : studentList) {
            if (s.getRegno().equalsIgnoreCase(regno)) {
                System.out.println("Student with Reg No " + regno + " already exists!");
                // Stop adding this student
            }
        }
        //DOB
        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.next();
        while (!dob.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            System.out.print("Invalid DOB format! Enter again (dd-mm-yyyy): ");
            dob = sc.next();
        }
        //GPA
        System.out.println("Enter GPA for 8 semesters (0.0 - 10.0):");
        ArrayList<Double> gpalist = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            double gpa;
            while (true) {
                System.out.print("SEM " + i + " GPA: ");
                if (sc.hasNextDouble()) {
                    gpa = sc.nextDouble();
                    if (gpa >= 0 && gpa <= 10) {
                        gpalist.add(gpa);
                        break; // valid, go to next sem
                    } else {
                        System.out.println("GPA must be between 0.0 and 10.0!");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next(); // consume wrong input
                }
            }
        }
        //MailId
        String mailId;
        System.out.print("Enter Mail Id: ");
        mailId = sc.next();
        while (!mailId.matches("[\\w]*@*[a-z]*\\.*[\\w]{3,}(\\.)*(com)*(@gmail\\.com)")) {
            System.out.print("Invalid Mail Id format! Enter again (xyz@gmail.com): ");
            mailId =sc.next();
        }
        //Contact
        String contact;
        System.out.print("Enter Mobile Number: ");
        contact = sc.next();
        while(contact.length()!=10){
            System.out.print("Invalid mobile number! Enter again: ");
            contact = sc.next();
        }
        Student s = new Student(name, regno, dob, gpalist, mailId, contact);
        studentList.add(s);
        System.out.println("Student added successfully!");
    return "Name: "+s.getName()+
           "\nReg no: "+s.getRegno()+
           "\nDOB: "+s.getDOB()+
           "\nGPA for sem(1-8): "+s.getGPA()+
           "\nMail Id: "+s.getMailId()+
           "\nContact no: "+s.getContact();
    }

    public String displayStudents(){
        StringBuilder content = new StringBuilder();
        try{
            File file  = new File("D:\\Projects\\Student Management System\\Students Data.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                content.append(reader.nextLine()).append("\n");
            }
            reader.close();
        }catch (FileNotFoundException e){
            return "Student data file not found!";
        }
        return content.toString();
    }

    public String searchStudent(String regno){
        for(Student s: studentList){
            if(s.getRegno().equals(regno)){
                return s.toString();
            }
        }
        return "Student with Reg no. "+regno+" not found!";
    }


    public void deleteStudentByRegNo(String regNoToDelete) throws IOException {
        Path path = Paths.get("D:\\Projects\\Student Management System\\Students Data.txt");
        List<String> lines = Files.readAllLines(path);

        List<String> updatedLines = new ArrayList<>();
        boolean skipBlock = false;
        boolean found = false;

        for (String line : lines) {
            if (line.startsWith("Name:")) {
                if (!skipBlock) {
                    updatedLines.add(""); // Add line break between blocks
                }
                skipBlock = false;
            }

            if (line.startsWith("Reg no:")) {
                String regNo = line.split(":")[1].trim();
                if (regNo.equalsIgnoreCase(regNoToDelete)) {
                    skipBlock = true;
                    found = true;
                }
            }

            if (!skipBlock) {
                updatedLines.add(line);
            }
        }

        Files.write(path, updatedLines.stream()
                .filter(l -> !l.trim().isEmpty())
                .collect(Collectors.toList()));

        if (found) {
            System.out.println("✅ Student deleted successfully.");
        } else {
            System.out.println("⚠️ Student with that Reg No not found.");
        }
    }
}

