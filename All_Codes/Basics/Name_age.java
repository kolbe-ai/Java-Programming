package codes;
import java.io.*;
public class Name_age {
    public static void main(String[] args){
        try {
            DataInputStream n = new DataInputStream(System.in);
            String s;
            int age, name, weight;
            System.out.print("Enter your age : ");
            s = n.readLine();
            age = Integer.parseInt(s);
            System.out.print("Enter your weight : ");
            s = n.readLine();
            weight = Integer.parseInt(s);
            System.out.print("Enter your name : ");
            s = n.readLine();
            System.out.println("\nMy name is " + s + " I am " + age + " years old and I weight " + weight + " yeah I am fat");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
