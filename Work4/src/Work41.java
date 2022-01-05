import java.util.Scanner;
import java.util.regex.Pattern;

public class Work41 {

    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        String str3 = input.next();
        String reg1 = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$";
        boolean qr1 = str1.matches(reg1);
        boolean qr2 = str2.matches("(\\d{15}|\\d{18})");
        String reg3 = "^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$";
        boolean qr3 = str3.matches(reg3);
        if(qr1&&qr2&&qr3){
            System.out.println("Correct!");
        }
    }
}
