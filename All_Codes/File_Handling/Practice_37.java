//37. Count the vowels, consonants and digits in a text file.

import java.io.*;

public class Practice_37{
    public static void main(String[] args){
        try{
            FileWriter fw = new FileWriter("example.txt",true);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("\n1234567890987trewqwer  90km tyuiopkjhvcxv y jbnkjohuejfndmc4riejofdk 09ejafp;pa;ja;  a [;jdfn liahl njnjvaluenv498nva d nf9438 ndf oadflg");
            br.close();

            FileInputStream fis = new FileInputStream("example.txt");
            int ch;
            int vowels = 0;
            int consonants = 0;
            int digit = 0;
            while((ch = fis.read()) != -1){
                char c = (char)ch;
                if (Character.isLetter(c)){
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                     c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                        vowels ++;
                    }else{
                        consonants++;
                    }            
                }else if (Character.isDigit(c)){
                    digit++;
                }                
            }
            System.out.printf("\n\nNumber of vowels is: %d\nNumber of consonants: %d\nNumber of digit: %d",vowels,consonants,digit);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}