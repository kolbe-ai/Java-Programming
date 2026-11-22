//38. Encrypt file contents using Caesar Cipher
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class L38{
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("java_test_file.txt");      //openning data for writting
            System.out.print("Enter the data: ");
            Scanner sc = new Scanner(System.in);
            String data = sc.nextLine();
            fos.write(data.getBytes());            //writing data
            fos.close();

            FileInputStream fis = new FileInputStream("java_test_file.txt");        //openning data for read
            FileOutputStream fos_e = new FileOutputStream("java_test_file_1.txt");      //openning data for writting encryption

            int content;
            int shift = 5;              //shift for shift the contents 

            System.out.print("\nContents in the file is: ");
            while((content = fis.read()) != -1){
                System.out.printf("%c",content);

                if((content>='A' && content<= 'Z')){             //taking only letter, we can do either way
                    content = 'A'+ (((content - 'A')+shift)%26);            //doing equation
                }else if(content>='a' && content<='z'){             //taking only letter, we can do either way
                    content = 'a'+ (((content - 'a')+shift)%26);            //doing equation
                }
                fos_e.write(content);        
            }
            
            FileInputStream fis_e = new FileInputStream("java_test_file_1.txt");        //openning data for read 
            content = 0;
            System.out.print("\n\nEncrypted contents in the file is: ");
            while((content = fis_e.read()) != -1){
                System.out.printf("%c",content);
            }




        }catch (Exception e){
            System.out.println(e);
        }
    }
}