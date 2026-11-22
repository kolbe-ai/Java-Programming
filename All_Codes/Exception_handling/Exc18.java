/*
Build a menu-driven calculator (Add / Subtract / Divide / Exit) in a loop. 
Handle divide-by-zero and non-numeric input without crashing.
*/

import java.util.Scanner;

class Exc18{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            while(true){
                System.out.print("Enter 1 to add\nEnter 2 to subtract \nEnter 3 to divide \nEnter 0 to exit\n\nEnter your choice: ");
                int choice = sc.nextInt();
                System.out.print("Enter the number 1: ");
                int num1 = sc.nextInt();
                System.out.print("Enter the number 2: ");
                int num2 = sc.nextInt();
    
                switch(choice){
                    case 1:
                        System.out.printf("\nSum is: %d\n\n",(num1+num2));
                        break;
                    case 2:
                        System.out.printf("\nDiff is: %d\n\n",(num1-num2));
                        break;
                    case 3:
                        float res = num1/num2;
                        System.out.printf("\nDiv is: %.2f\n\n",res);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("\nInvalid input!\n\n");
                }
            }
        }catch(ArithmeticException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}