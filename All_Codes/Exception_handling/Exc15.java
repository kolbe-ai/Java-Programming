/*
Write a password validator that throws a custom exception unless the password has 
at least 8 characters, one digit, one uppercase letter and one special character. 
Print the specific reason for the failure.
*/


import java.util.Scanner;

class PasswordException extends Exception{
    PasswordException(String message){
        super(message);
    }
}



public class Exc15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            if(pass.length() < 8){
                throw new PasswordException("Password should have atleast 8 character");
            }

            boolean digit_aval = false;
            boolean upper_aval = false;
            boolean special_aval = false;
            
            for (int i = 0 ; i<pass.length() ; i++){
                char ch = pass.charAt(i);
                if (Character.isDigit(ch)){
                    digit_aval = true;
                }
                if (Character.isUpperCase(ch)){
                    upper_aval = true;
                }
                if (!Character.isLetterOrDigit(ch)){
                    special_aval = true;
                }
            }
            if (digit_aval == false || upper_aval == false || special_aval == false){
                throw new PasswordException("Please should have atleast one digit, one uppercase letter and one special character. ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
}