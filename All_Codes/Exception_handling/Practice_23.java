//23. Develop a teacher performance score processing system with a user-defined exception for scores outside 0 to 100.

import java.util.Scanner;

class InvalidScoreException extends Exception{
    InvalidScoreException(String message){
        super(message);
    }
}

public class Practice_23{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.print("Enter you score: ");
            int score = sc.nextInt();
    
            if (score>100 || score <0){
                throw new InvalidScoreException("Invalid score");
            }
        }catch (InvalidScoreException e){
            System.out.println("Error occured: "+e.getMessage());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}