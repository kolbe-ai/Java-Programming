import java.util.Scanner;
public class Mul{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number from 1 - 20 you wish to get the multiplication of : ");
		int num = scn.nextInt();
		System.out.println("\n\nTHE MULTIPLICATION TABLE OF "+num+"\n");
		for(int i = 1; i<=20 ; i++){
			System.out.println(num+" x "+i+" = "+(num*i));
		}
	}
}