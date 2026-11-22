import java.io.*;
import java.util.Scanner;
public class Namen{
	public static void main(String[] args){
		try{
			System.out.println("Your name is : "+args[0]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error");
		}
	}
}