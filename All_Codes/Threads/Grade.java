import java.io.*;
public class Grade{
	public static void main(String[] args){
		try{
			DataInputStream dis = new DataInputStream(System.in);
			int maths,c, python, cyber,java,ai;
			System.out.println("ENTER MARKS OUT OF 100\n");
			System.out.print("Enter your Maths mark : ");
			maths = Integer.parseInt(dis.readLine());
			System.out.print("Enter your C programing mark : ");
			c = Integer.parseInt(dis.readLine());
			System.out.print("Enter your Python programming mark : ");
			python = Integer.parseInt(dis.readLine());
			System.out.print("Enter your Cyber Security mark : ");
			cyber = Integer.parseInt(dis.readLine());
			System.out.print("Enter your Java programming mark : ");
			java = Integer.parseInt(dis.readLine());
			System.out.print("Enter your AI mark : ");
			ai = Integer.parseInt(dis.readLine());
			int total = maths+c+python+cyber+java+ai;           //total marks
			System.out.println("\n\nThe total marks you gained out of 600 is : "+total);
			int avg = total/6;                   //average marks
			if(avg >= 90){
				System.out.println("\nYour grade is : A grade");
			}else if (avg>=80){
				System.out.println("\nYour grade is : B grade");
			}else if (avg>=70){
				System.out.println("\nYour grade is : C grade");
			}else if (avg>=60){
				System.out.println("\nYour grade is : D grade");
			}else if (avg>=50){
				System.out.println("\nYour grade is : E grade");
			}
		}catch(IOException e){
			System.out.println("Error in IO");
		}
	}
}