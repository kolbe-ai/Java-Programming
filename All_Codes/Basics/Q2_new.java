package codes;
import java.util.Scanner;
public class Q2_new {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = obj.nextInt();
        if(num%2 == 1){
            System.out.println("The given number is odd");
        }else{
            System.out.println("The given number is even");
        }
    }
}
