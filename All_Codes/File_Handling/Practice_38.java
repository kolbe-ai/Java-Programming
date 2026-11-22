//38 Encrypt the contents of a file using a Caesar Cipher.

import java.io.*;
public class Practice_38{
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("encrpted_example.txt");
            FileInputStream fis = new FileInputStream("example.txt");
            int key = 3;
            int ch;
            System.out.println("\n\nOrginal file: ");
            while((ch = fis.read()) != -1){
                System.out.printf("%c",ch);
                ch = ch+key;        //adding key
                fos.write(ch);
            }
            fos.close();
            fis.close();
            FileReader fr = new FileReader("encrpted_example.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("\n\n\nEncrpted File is: ");
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}