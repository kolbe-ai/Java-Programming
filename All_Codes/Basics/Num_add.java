package codes;
import java.util.Scanner;
public class Num_add {
    public static void main(String[] args) {
        System.out.print("Enter the number 1 : ");
        Scanner num = new Scanner(System.in);
        int n1 = num.nextInt();
        System.out.print("Enter the number 2 : ");
        int n2 = num.nextInt();
        System.out.println("\nThe first number : " + n1 + "\nThe second number : " + n2+"\nThe sum : " + (n1+n2));
    }
}
