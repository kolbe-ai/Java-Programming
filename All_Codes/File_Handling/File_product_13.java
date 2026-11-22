/*
13. Write a Java program to write a few product records (product code, name, price)
into a text file, then read and display all the records from the file. Also display the
total price of all products.
*/

import java.io.*;
import java.util.Scanner;

public class File_product_13{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the product code: ");
            int p_id = sc.nextInt();
            System.out.print("Enter the product name: ");
            sc.nextLine();
            String p_name = sc.nextLine();
            System.out.print("Enter the product price: ");
            int p_price = sc.nextInt();
            
            FileOutputStream fos = new FileOutputStream("product.txt",true);
            String data = "\nID: "+p_id+"\tName: "+p_name+"\tPrice: "+p_price;   
            fos.write(data.getBytes());
            fos.close();

            FileInputStream fis = new FileInputStream("product.txt");
            int ch;
            while((ch = fis.read()) != -1){
                System.out.printf("%c",ch);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}