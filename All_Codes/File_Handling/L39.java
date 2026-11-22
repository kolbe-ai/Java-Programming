//39. Search a word in a text file.
import java.io.*;
import java.util.Scanner;

public class L39{
    public static void main(String [] args){
        try{
            /*
            //using FileOutputStream for writting 
            FileOutputStream fos = new FileOutputStream("java_test_file.txt");
            String data;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the data: ");
            data = sc.nextLine();
            fos.write(data.getBytes());
            fos.close();


            FileInputStream fis = new FileInputStream("java_test_file.txt");
            int contents;
            System.out.print("Contents in the file is: ");
            while((contents = fis.read()) != -1){
                System.out.printf("%c",contents);

            }
            */

            //using buffer
            FileWriter fw = new FileWriter("java_test_file.txt");
            String data;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the data: ");
            data = sc.nextLine();
            fw.write(data);
            fw.close();

            BufferedReader br = new BufferedReader (new FileReader("java_test_file.txt"));
            String line;
            System.out.print("Enter the word to search: ");
            String word = sc.nextLine();
            boolean found = false;
            while((line = br.readLine()) != null){
                if(line.contains(word)){
                    found = true;
                }
            }
            if(found){
                System.out.printf("The word %s found in the file!",word);
            }else{
                System.out.printf("The word %s not found in the file!",word);
            }

        }catch(Exception e){
            System.out.println(e);
        }




    }
}