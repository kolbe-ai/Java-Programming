//39. Search for a word in a text file.

import java.io.*;
import java.util.Scanner;

public class Practice_39{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            FileReader fr = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fr);
            String sentence;
            System.out.print("Enter the word to check: ");
            String check = sc.nextLine();
            boolean found =false;
            while((sentence = br.readLine()) != null){
                if(sentence.contains(check)){
                    found = true;
                    System.out.println("\nWord found!");
                    return;
                }
            }
            if(!found){
                System.out.println("\nWord not found!");
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}