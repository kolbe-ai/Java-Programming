package codes;
import java.util.Scanner;

public class Natural {
    public static void main(String[] args){
        System.out.print("Enter the number till you need to see natural number : ");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        System.out.println("The natural numbers ");
        if ( n == 0){
            System.out.println("Zero is not a natural number");
        }
        for (int i = 1 ; i<=n ; i++){
            System.out.println(i);
        }
    }
}
