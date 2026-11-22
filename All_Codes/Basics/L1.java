//Write a program to determine whether a number is an Armstrong number

import java.util.Scanner;
public class L1 {
    public static void main(String[] args){
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dup = n;
        int count = (int) Math.log10(n)+1;
        int arm = 0 ;
        for(int i = 0 ; i<count ; i++){
            arm += Math.pow((dup%10),count);
            dup = dup/10;
        }
        if(arm == n){
            System.out.print("The given number is Armstrome");
        }else{
            System.out.print("The given number is not Armstrome");
        }
    }
}
