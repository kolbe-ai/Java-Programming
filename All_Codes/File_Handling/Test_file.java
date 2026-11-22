import java.io.*;

public class Test_file{
    public static void main(String[] args){
        try{
            File f = new File("example.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String sr;
            while((sr = br.readLine()) != null){
                System.out.println(sr);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}