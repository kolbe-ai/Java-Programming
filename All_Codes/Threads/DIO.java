import java.io.*;
public class DIO{
	public static void main(String[] args){
		try{
			String s;
			int num1;
			float num2;
			String num3;
			System.out.print("Enter a number : ");
			DataInputStream dis = new DataInputStream(System.in);
			s = dis.readLine();
			num1 = Integer.parseInt(s);
			System.out.print("Enter another number : ");
			s = dis.readLine();
			num2 = Float.parseFloat(s);
			System.out.print("Enter another number : ");
			num3 = dis.readLine();
			System.out.println("The number 1 (int): "+num1+"\nThe number 2 (float): "+num2+"\nThe number 3 (string): "+num3);		
		}catch(IOException e){
			System.out.println("Error found!");			
		}
	}
	
}