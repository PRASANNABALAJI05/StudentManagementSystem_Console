import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputId;
        String inputPassword;
        System.out.println("=====Student Management System=====");
        System.out.print("Enter Admin ID: ");
        inputId = sc.nextInt();
        System.out.print("Enter Password: ");
        inputPassword = sc.next();

        if (Admin.authenticate(inputId, inputPassword)) {
            System.out.println("Login Successful");
            System.out.println("===================================");
            StudentManager sm = new StudentManager();
            while(true){
               Scanner m = new Scanner(System.in);
            System.out.println("===============MENU================");
            System.out.println("1. Add Student\n2. Display all students.\n3. Search student by Reg No\n4. Delete student\n5. Save\n6. Exit");
            System.out.print("Enter Choice: ");
            int menu = m.nextInt();
            switch (menu) {
                case 1:
                    String addStd = sm.addStudents();
                    System.out.println("===================================");
                    System.out.println(addStd);
                    break;

                case 2:
                    String display = sm.displayStudents();
                    System.out.println("===================================");
                    System.out.println(display);
                    System.out.println("===================================");

                    break;

                case 3:
                    System.out.println("===================================");
                    System.out.print("Enter Reg no: ");
                    String search = sm.searchStudent(sc.next());
                    System.out.println(search);
                    System.out.println("===================================");
                    break;
                case 4:
                    System.out.println("===================================");
                    System.out.println("Enter Reg no: ");
                    String regToDelete = m.next();
                    try {
                        sm.deleteStudentByRegNo(regToDelete);
                    }catch(IOException e){
                        System.out.println("Error while removing a student"+e.getMessage());
                    }
                    System.out.println("===================================");

                    break;

                case 5:
                    StoreDetails sd = new StoreDetails();
                    try {
                        sd.storeDetails(sm);
                    } catch (IOException e) {
                        System.out.println("Error while saving students data" + e.getMessage());
                    }
                    System.out.println("===================================");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Input!");
            }
           }
        } else {
            System.out.println("Invalid login! Access Denied");
            System.out.println("===================================");
        }
    }
}