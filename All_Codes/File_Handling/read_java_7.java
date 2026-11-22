/*
7. Write a Java program to read a text file given by the user and count the number of
characters, words and lines in it. Display the counts along with the file's contents.
Display an error message if the file does not exist.
*/

import java.io.*;
import java.util.Scanner;

public class read_java_7{
    public static void main(String[] args){
        try{
            System.out.print("Enter the file name: ");
            Scanner sc = new Scanner(System.in);
            String content = sc.nextLine();
            FileReader r = new FileReader(content);
            BufferedReader br = new BufferedReader(r);

            int characters = 0;
            int words = 0;
            int lines = 0;
            
            System.out.println("The contents of the file is: \n");
            String line;
            while((line = br.readLine())!= null){
                lines++;
                System.out.println(line);
                characters += line.length();

                String trim_line = line.trim();
                if(!trim_line.isEmpty()){
                    String[] arr_line = trim_line.split("\\s+");
                    words += arr_line.length;
                }
            }
            br.close();
            r.close();

            /*FileInputStream fis = new FileInputStream(content);
            int character;
            while((character = fis.read()) != -1){
                //System.out.printf("%c",character);
                characters++;
                if(character == ' '){
                    words++;
                }
            }*/

            System.out.printf("\n\nThe file have %d words, %d characters, %d lines",words,characters,lines);
        }catch (FileNotFoundException f){
            System.out.println("File Not Found!");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}