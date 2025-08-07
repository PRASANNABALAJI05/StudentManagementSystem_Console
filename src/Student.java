import java.util.List;
public class Student {
    String name;
    String regno;
    String dob;
    List<Double> gpalist;
    String mailId;
    String contact;
//Constructor for the class Student
    Student(String name, String regno, String dob, List<Double> gpalist, String mailId, String contact){
        this.name = name;
        this.regno = regno;
        this.dob = dob;
        this.gpalist = gpalist;
        this.mailId = mailId;
        this.contact = contact;
    }
//Getter and Setter
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getRegno(){
        return regno;
    }
    public void setRegno(){
        this.regno = regno;
    }
    public String getDOB(){
        return dob;
    }
    public void setDOB(String dob){
         this.dob = dob;
    }
    public List<Double> getGPA(){
        return gpalist;
    }
    public void setGPA(List<Double> gpalist){
        this.gpalist = gpalist;
    }
    public String getMailId(){
        return mailId;
    }
    public void setMailId(String mailId){
        this.mailId = mailId;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        if(contact.length()==10)
        this.contact = contact;
    }
//Overriding to set a format
    @Override
    public String toString() {
        return "\nName: "+name+
               "\nReg no: "+regno+
               "\nDOB: "+dob+
               "\nGPA (8 sem): "+gpalist+
               "\nMail Id: "+mailId+
               "\nContact: "+contact;
    }
}
