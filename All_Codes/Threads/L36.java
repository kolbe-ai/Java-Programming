//36. Demonstrate thread priorities.

import java.util.Scanner;
class Hospital extends Thread{
    public void run(){
        System.out.printf("\nThread priority is: %d",getPriority());
        System.out.printf("\nEnter the new priority (1-10) : ");
        Scanner sc= new Scanner(System.in);
        int p = sc.nextInt();
        
        setPriority(p);
        System.out.printf("\nNew thread priority is: %d",getPriority());
    }
}

public class L36{
    public static void main(String[] args){
        Hospital h1 = new Hospital();
        h1.start();
    }
}