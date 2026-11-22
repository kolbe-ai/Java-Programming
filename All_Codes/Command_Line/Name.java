import java.io.*;

public class Name{
	public static void main(String[] args){
		try{
			int n = args.length;
			System.out.println("No of argument : "+n);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("\nNo argument found! ");
		}
	}
}