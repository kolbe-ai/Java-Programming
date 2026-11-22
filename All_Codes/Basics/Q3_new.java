package codes;

import java.util.Scanner;
public class Q3_new {
    public static void main(String[] args){
        System.out.print("Enter the number till you want series: ");
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int num1 = 0;
        int num2 = 1;
        System.out.print("\nFibnocci Series : ");
        for(int i = 1; i<n ; i++){
            System.out.print(num1+" ");
            int next = num2+num1;
            num1 = num2;
            num2 = next;
        }
    }
}
