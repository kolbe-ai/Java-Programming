package codes;
import java.util.Scanner;
public class P4 {
    public static void main(String[] args){
        System.out.print("Enter 3 numbers : ");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        if(num1>num2){
            if(num1>num3){
                System.out.println("Greated number is : "+num1);
            }else{
                System.out.println("Greated number is : "+num3);
            }
        }else{
            if (num2>num3){
                System.out.println("Greated number is : "+num2);
            }else{
                System.out.println("Greated number is : "+num3);
            }
        }
    }

}
