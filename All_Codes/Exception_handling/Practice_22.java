//22. Create a menu-driven calculator application with exception handling (invalid input, divide by zero).

import java.util.Scanner;

class ZeroDivision extends Exception{
    ZeroDivision(String message){
        super(message);
    }
}

class InvalidInput extends Exception{
    InvalidInput(String message){
        super(message);
    }
}

public class Practice_22{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter number 1: ");
            int num1 = sc.nextInt();
            sc.nextLine();          //consumes the leftover \n
            System.out.print("Enter the operator: ");
            String op = sc.nextLine();
            System.out.print("Enter number 2: ");
            int num2 = sc.nextInt();
            if(op.equals("+")){
                System.out.printf("\n\nResult: %d",(num1+num2));
            }else if(op.equals("-")){
                System.out.printf("\n\nResult: %d",(num1-num2));
            }else if (op.equals("*")){
                System.out.printf("\n\nResult: %d",(num1*num2));
            }else if (op.equals("/")){
                if (num2 != 0){
                    System.out.printf("\n\nResult: %.2f",(num1/num2));
                }else{
                    throw new ZeroDivision("Division by zero not possible");
                }
            }else{
                throw new InvalidInput("Invalid Operator!");
            }
        }catch(ZeroDivision z){
            System.out.println("Error occured: "+z.getMessage());
        }catch(InvalidInput i){
            System.out.println("Error occured: "+i.getMessage());
        }catch(Exception e){
            System.out.println("Error occured: "+e.getMessage());
        }
    }
}