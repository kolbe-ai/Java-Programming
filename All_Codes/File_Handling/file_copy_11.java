/*
11. Write a Java program to copy the contents of one text file into another, with both file
names entered by the user. Display the number of characters copied and the
contents of the new file. Handle the case where the source file does not exist
*/

import java.io.*;
import java.util.Scanner;
public class file_copy_11{
    public static void main(String[] args){
        try{
            File f1 = new File("abcd_java.txt");            //file creation
            System.out.print("Enter the file name: ");
            Scanner sc = new Scanner(System.in);
            String file_name = sc.nextLine();
            FileWriter fw1 = new FileWriter(file_name);
            BufferedWriter br1 = new BufferedWriter(fw1);
            br1.write("Hello how are you?\nGood to see you!");
            br1.close();
            fw1.close();

            File f2 = new File("abcd_jaba_1.txt");          //file creation
            System.out.print("Enter the file name of second file: ");
            String file_name1 = sc.nextLine();
            FileWriter fw = new FileWriter(file_name1);
            FileReader fr = new FileReader(file_name);
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("Contents in the file is: ");
            while((line = br.readLine()) != null){
                System.out.println(line);
                bw.write(line);
            }

        }catch( Exception e){
            System.out.println(e);
        }     
    }
}