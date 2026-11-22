/*
23. Write a Java program to read a text file and a word entered by the user, then count
and display how many times the word occurs in the file. Display an error message if
the file does not exist.
*/

import java.io.*;
import java.util.Scanner;

public class Count_w_23{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the file name: ");
            String f_name = sc.nextLine();
            System.out.print("Enter the word: ");
            String word = sc.nextLine();

            File f = new File(f_name);
            if(!f.exists()){
                System.out.println("File not found!\n");
            }
            FileReader fr = new FileReader(f_name);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;

            while((line = br.readLine()) != null){
                if(line.contains(word)){
                    count++;
                }
            }
            System.out.println("Number of searched word: "+count);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}