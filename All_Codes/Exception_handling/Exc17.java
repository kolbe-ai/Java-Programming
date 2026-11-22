/*
Q17. Write a program that reads a file name from the user and prints its contents. 
Handle FileNotFoundException and IOException separately. 
*/

import java.util.Scanner;
import java.io.*;

class Exc17{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the file name: ");
            String file_name = sc.nextLine();
            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                System.out.print(line);
            }
        }catch(FileNotFoundException f){
            System.out.println(f);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}