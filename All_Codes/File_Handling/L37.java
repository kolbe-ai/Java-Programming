//37. Count vowels, consonants and digits in a file.

import java.io.FileInputStream;     //for reading
import java.io.FileOutputStream;    //for writting
import java.io.IOException;

public class L37{
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("java_test_file.txt");
            fos.write("jnfoisj32ijwedn 2u3dndddd2dd3ddddnw 23wd dined 83ed 3imdwelmqlmd dddd".getBytes());   //.getBytes convert this
            fos.close();

            FileInputStream fis = new FileInputStream("java_test_file.txt");
            int data = 0;
            System.out.print("Contents in the file is: ");

            int vovels = 0;
            int consonants = 0;
            int digits = 0;

            while((data = fis.read()) != -1){
                System.out.printf("%c",data);    //printing the contens of the file
                if (data >= '0' && data <= '9'){
                    digits++;
                }else if ((data >= 'A' && data <= 'Z') ||(data >= 'a' && data <= 'z')){
                    if (data == 'A' ||data == 'E' ||data == 'I' ||data == 'O' ||data == 'U' ||
                        data == 'a' ||data == 'e' ||data == 'i' ||data == 'o' ||data == 'u'){
                        vovels++;

                    }else{
                        consonants++;
                    }
                }
            }
            System.out.println("\n");
            System.out.printf("\n\nThe number of vowels: %d\nThe number of consonets: %d\nThe number of digits: %d",vovels,consonants,digits);


            fis.close();
        }catch( Exception e){
            System.out.print(e);
        }
    }
}