package codes;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        n = input.nextInt();
        if ( n%5 == 0 && n%3 == 0){
            System.out.println("FrizzBuzz");
        }else if (n%3 == 0){
            System.out.println("Buzz");
        }else if(n%5 == 0){
            System.out.println("Frizz");
        }else{
            System.out.println(n);
        }


    }
}