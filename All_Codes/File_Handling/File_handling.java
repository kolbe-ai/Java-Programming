import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_handling{
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("C:\\Notepad\\java_test_file.txt");
            FileOutputStream fos = new FileOutputStream("text_java_1.txt");
            int data;
            while((data = fis.read()) != -1){
                System.out.printf("%c",data);
                fos.write(data);
            }
            System.out.printf("\nThe data copied sucessfully!");
        }catch (Exception e){
            System.out.print(e);
        }
    }
}
