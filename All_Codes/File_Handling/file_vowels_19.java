/*
19. Write a Java program to read a text file given by the user and display its contents in
uppercase. Also count and display the number of vowels in the file. Display an error
message if the file does not exist.
*/

import java.util.Scanner;
import java.io.*;
public class file_vowels_19{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the file name: ");
            String file_name = sc.nextLine();

            FileInputStream fis = new FileInputStream(file_name);
            int ch;
            int vowels = 0;
            System.out.println("Contents is: ");
            while((ch = fis.read()) != -1){
                if (ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u'
                    || ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'){
                        vowels++;
                    }
                    System.out.printf("%c",Character.toUpperCase(ch));
            }
            fis.close();
            System.out.println("Number of vowels : "+vowels);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}