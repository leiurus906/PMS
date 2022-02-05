import com.sun.istack.internal.NotNull;
import java.lang.Math;

public class Password_Generator {

    private final char [] lowerCase = new char [] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};
    private final char [] upperCase = new char [] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final char [] decimals = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final char [] specialChar = new char[] {'!', '"','#','$','%','&','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[',']','^',
            '_','`','{','|','}','~'};
    @NotNull private int passwordLength;
    @NotNull private int numberOfUpperCaseChar;
    @NotNull private int numberOfLowerCaseChar;
    @NotNull private int numberOfDecimalChar;
    @NotNull private int numberOfSpecialChar;

    Password_Generator() {
        this(18,4,6,3,5);
}

    Password_Generator(int passwordLength, int numberOfUpperCaseChar, int numberOfLowerCaseChar, int numberOfDecimalChar, int numberOfSpecialChar){

        this.passwordLength = passwordLength;
        this.numberOfUpperCaseChar = numberOfUpperCaseChar;
        this.numberOfLowerCaseChar = numberOfLowerCaseChar;
        this.numberOfDecimalChar = numberOfDecimalChar;
        this.numberOfSpecialChar = numberOfSpecialChar;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public void setNumberOfUpperCaseChar(int numberOfUpperCaseChar) {
        this.numberOfUpperCaseChar = numberOfUpperCaseChar;
    }

    public void setNumberOfLowerCaseChar(int numberOfLowerCaseChar) {
        this.numberOfLowerCaseChar = numberOfLowerCaseChar;
    }

    public void setNumberOfDecimalChar(int numberOfDecimalChar) {
        this.numberOfDecimalChar = numberOfDecimalChar;
    }

    public void setNumberOfSpecialChar(int numberOfSpecialChar) {
        this.numberOfSpecialChar = numberOfSpecialChar;
    }

    String generatePassword(){
        String password = "";
        int i = this.passwordLength;
        int d = this.numberOfDecimalChar;
        int l = this.numberOfLowerCaseChar;
        int s = this.numberOfSpecialChar;
        int u = this.numberOfUpperCaseChar;

        int max = 4;
        int min = 1;
        int range = max - min + 1;
        while(i!=0) {
            int rand = (int) (Math.random() * range) + min;
            switch (rand){
                case 1:{
                    if(u!=0){
                        int randu = (int)(Math.random() * upperCase.length-1);
                        password += upperCase[randu];
                        u--;
                        i--;
                    }
                    else
                    break;
                }
                case 2:{
                    if(s!=0){
                        int rands = (int)(Math.random() * specialChar.length-1);
                        password += specialChar[rands];
                        s--;
                        i--;
                    }
                    else
                    break;
                }
                case 3:{
                    if(d!=0){
                        int randd = (int)(Math.random() * decimals.length-1);
                        password += decimals[randd];
                        d--;
                        i--;
                    }
                    else
                    break;
                }
                case 4:{
                    if(l!=0){
                        int randl = (int)(Math.random() * lowerCase.length-1);
                        password += lowerCase[randl];
                        l--;
                        i--;
                    }
                    else
                    break;
                }

            }
        }
        return password;

    }

}
