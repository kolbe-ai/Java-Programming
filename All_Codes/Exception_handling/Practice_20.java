//20. Create a custom InvalidAgeException that is thrown when a teacher’s age is not between 22 and 60.

import java.util.Scanner;

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class Practice_20{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your age: ");
            float age = sc.nextFloat();
            if (age >=22 && age <=60){
                System.out.println("\n\nYou are elligible for teacher application!");
            }else{
                throw new InvalidAgeException("Sorry you are not elligible");
            }
        }catch(InvalidAgeException age){
            System.out.println("Error: "+age.getMessage());
        }catch(Exception e){
            System.out.println("An Error occured");
        }finally{
            System.out.println("Thanks for participating!");
        }

    }
}