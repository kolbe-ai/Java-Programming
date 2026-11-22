//Write a Java program to write a few employee records (Emp name, salary) into a text
//file, then read and display all the records from the file. Also display the file's
//properties name, size, and whether it exists

import java.util.Scanner;
import java.io.*;

public class Emp_rec_file{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            FileOutputStream fos = new FileOutputStream("employee_record.txt",true);
            System.out.print("Enter the employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter the employee salary: ");
            float sal = sc.nextFloat();

            String data = "Employee name: "+name+"\nEmployee salary: "+sal+"\n\n";
            fos.write(data.getBytes());
            fos.close();

            System.out.println("\n\n|    EMPLOYEE RECORD     |\n");
            FileInputStream fis = new FileInputStream("employee_record.txt");
            int data1;
            while((data1 = fis.read()) != -1){
                System.out.printf("%c",data1);
            }
            File file = new File("employee_record.txt");
            System.out.println("\n\nFile name: "+file.getName());
            System.out.println("File size: "+file.length()+" bytes");

            fis.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}