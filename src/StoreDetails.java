import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class StoreDetails {
    public void storeDetails(StudentManager sm) throws IOException {
        File myFile = new File("D:\\Projects\\Student Management System\\Students Data.txt");
        FileWriter writer = new FileWriter("D:\\Projects\\Student Management System\\Students Data.txt");
            for(Student s: sm.studentList){
                writer.write(s.toString()+"\n\n");
            }
            writer.close();
        System.out.println("Student data saved successfully");

    }

}
