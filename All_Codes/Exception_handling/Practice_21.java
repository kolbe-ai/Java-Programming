//21. Validate a teacher’s login password (length, uppercase, digit, special character) using exception handling.

import java.util.Scanner;

class Password_check_Exception extends Exception{
    Password_check_Exception(String message){
        super(message);
    }
}

public class Practice_21{
    
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your password: ");
            String password = sc.nextLine();
            is_valid(password);
        }catch(Password_check_Exception p){
            System.out.println("Error: "+p.getMessage());
        }

    }
    static void is_valid(String message) throws Password_check_Exception{
        if (message.length() <= 8){
            throw new Password_check_Exception("Password Length should be atleast 8 character");
        }else{
            boolean special = false;
            boolean alpha = false;
            boolean digit = false;
            for (int i = 0 ; i< message.length() ; i++){
                char c= message.charAt(i);
                if (Character.isDigit(c)){
                    digit = true;
                }else if(Character.isLetter(c)){
                    alpha = true;                
                }else{
                    special = true;
                }
            }
            if (!special){
                throw new Password_check_Exception("Must contain special letter");
            }
            if (!alpha){
                throw new Password_check_Exception("Must contain 1 Letter letter");
            }
            if (!digit){
                throw new Password_check_Exception("Must contain 1 Digit letter");
            }
        }
    }
}