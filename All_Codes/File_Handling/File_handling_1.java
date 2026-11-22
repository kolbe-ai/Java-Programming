import java.io.*;
import java.util.Scanner;
class File_handling_1{
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("new_java_handling.txt");
            String data;
            Scanner sc = new Scanner(System.in);
            System.out.printf("Enter the details: ");
            data = sc.nextLine();
            System.out.printf("%s",data);
            fos.write(data.getBytes());
            fos.close();

            //reading
            FileInputStream fis = new FileInputStream("new_java_handling.txt");
            int data1;
            while((data1 = fis.read()) != -1){
                System.out.printf("%s",data1);
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
}