//24 Handle file-related exceptions (FileNotFoundException) in Java.

import java.io.*;
class FileNotFoundException extends Exception{
    FileNotFoundException(String message){
        super(message);
    }
}

class Practice_24{
    public static void main(String[] args){
        try{
            File f = new File("example123.txt");
            if (f.exists()){
                System.out.println("File Found!");
            }else{
                throw new FileNotFoundException("File not found");
            }
        }catch(FileNotFoundException file){
            System.out.println("Error occured: "+file.getMessage());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}