/*
Write a Java program to accept a few lines of text from the user and write them into
a text file using FileWriter. Then read the file using BufferedReader and display each
line with its line number.
*/

import java.io.*;
import java.util.Scanner;

public class buffer_file{
    public static void main(String[] args){
        try{
            FileWriter wr = new FileWriter("buffer_java.txt");
            Scanner sc = new Scanner (System.in);
            System.out.print("Enter the input value: ");
            String data = sc.nextLine();
            wr.write(data);
            wr.close();

            FileReader r = new FileReader("buffer_java.txt");
            BufferedReader br = new BufferedReader(r);
            String content;
            int line = 0;
            while((content = br.readLine()) != null){
                line++;
                System.out.println(line + ". "+ content);
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
}