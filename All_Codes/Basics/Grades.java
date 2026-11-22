package codes;

import java.util.Scanner;
public class Grades{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your grade : ");
        int grade = sc.nextInt();
        if(grade>=90){
            System.out.println("Your grade is : A");
        }else if(grade>=80){
            System.out.println("Your grade is : B");
        }else if(grade>=70){
            System.out.println("Your grade is : A");
        }else{
            System.out.println("Sorry you failed");
        }
    }
}