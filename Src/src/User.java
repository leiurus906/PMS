import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Person {

    private String E_mail;
    private ArrayList<String> savedPasswords = new ArrayList<>();
    private Password_Generator password_generator = new Password_Generator();

    public User(String name,String E_mail, String Username, String Password) {
        super(name);
        this.E_mail = E_mail;
        super.setPassword(Password);
        super.setUsername(Username);
    }
    private String generateNewPassword(){
        String password = password_generator.generatePassword();
        System.out.println("Password Generated: " + password);
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Would you like to save this password: "+"\n"+"1-Yes\n"+"2-No");
            int a  = s.nextInt();
            if (a==1){
                this.savedPasswords.add(password);
                System.out.println("Password Saved!");
            }else if(a==2){
                System.out.println("Password Discarded!");
            }else
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Please input 1 for Yes, or 2 for No");
            s.nextInt();
        }
        catch (InputMismatchException e1){
            System.out.println("Input Mismatch, please insert an integer.");
            s.nextInt();
        }
        return password;
    }

}
