package codes;
import java.util.Scanner;
public class greatest {
    public static void main(String[] args){
        System.out.print("Enter a number 1 : ");
        Scanner num = new Scanner(System.in);
        int n1 = num.nextInt();
        System.out.print("\nEnter a number 2 : ");
        int n2 = num.nextInt();
        System.out.print("\nEnter a number 3 : ");
        int n3 = num.nextInt();
        int max = n1>n2 ? (n1>n3?n1:n3) : (n2>n3?n2:n3);
        System.out.println("\nMaximum number : "+max);
    }
}
