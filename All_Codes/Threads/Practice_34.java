//34. Create multiple threads to process multiple file.


import java.io.*;

class File1 extends Thread{
    String f_name;
    File1(String f_name){
        this.f_name = f_name;
    }
    public void run(){
        try{
            FileReader f = new FileReader(f_name);
            int c;
            System.out.print("\n\n\n");
            while((c = f.read()) != -1){
                System.out.printf("%c",c);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class File2 extends Thread{
    String f_name;
    File2(String f_name){
        this.f_name = f_name;
    }
    public void run(){
        try{
            FileReader f = new FileReader(f_name);
            int ch;
            while((ch = f.read()) != -1){
                System.out.printf("%c",ch);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class File3 extends Thread{
    String f_name;
    File3(String f_name){
        this.f_name = f_name;
    }
    public void run(){
        try{
            FileReader f = new FileReader(f_name);
            int ch;
            System.out.print("\n\n\n");
            while((ch = f.read()) != -1){
                System.out.printf("%c",ch);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class Practice_34{
    public static void main(String[] args){
        File2 f2 = new File2("example1.txt");
        File1 f1 =new File1("example.txt");
        f1.start();
        f2.start();
    }
}