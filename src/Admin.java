import java.util.ArrayList;
import java.util.List;
public class Admin {
    private int adminId;
    private String password;

    private static List<Admin> adminList = new ArrayList<>();
    Admin(int adminId, String password){
        this.adminId = adminId;
        this.password = password;
    }
    public int getAdminId(){
        return adminId;
    }
    public void setAdminId(int adminId){
        this.adminId = adminId;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    static {
        adminList.add(new Admin(12345, "sec123"));
        adminList.add(new Admin(12346,"sec321"));
        adminList.add(new Admin(12347,"sec147"));
    }
    public static boolean authenticate(int inputId, String inputPassword) {
        for(Admin admin: adminList){
            if(admin.adminId == inputId && admin.password.equals(inputPassword)){
                return true;
            }
        }
        return false;
    }
}
