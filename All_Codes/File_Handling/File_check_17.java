/*
17. Write a Java program to accept a file name from the user and check whether the file
exists using the File class. If it exists, append a line of text entered by the user to it
using FileWriter. If it does not exist, create it and write the line. Finally, display the
complete contents of the file.
*/

import java.io.*;
import java.util.Scanner;

public class File_check_17{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the file name: ");
            String file_name = sc.nextLine();
            File f = new File(file_name);
            if(!f.exists()){
                System.out.println("\nFile doesn't exist\nCreating a file...!\n");
                f.createNewFile();
            }
            System.out.print("Enter the things to enter: ");
            String data = sc.nextLine();
            FileWriter fw = new FileWriter(file_name,true);
            fw.write(data);
            fw.close();



            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("\nContents in the file is: \n");
            while((line = br.readLine()) != null){
                System.out.print(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{

        }
    }
}