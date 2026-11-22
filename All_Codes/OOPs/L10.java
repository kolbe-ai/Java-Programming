//10. Create a Distance class and add two distances.

import java.util.Scanner;
class Meter{
    public int m,cm,mm;
    void read(){
        System.out.print("Enter the Meter : ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        System.out.print("Enter the CM : ");
        cm = sc.nextInt();
        System.out.print("Enter the MM : ");
        mm = sc.nextInt();
    }
    void display(){
        System.out.println("The Distance is: "+m+"m "+cm+"cm "+mm+"mm\n\n");
    }
    Meter add(Meter m){
        Meter dup = new Meter();
        dup.m = this.m+ m.m;
        dup.cm = this.cm+ m.cm;
        dup.mm = this.mm+ m.mm;
        return dup;
    }
}

public class L10{
    public static void main(String[] args){
        Meter m1 = new Meter();
        m1.read();
        m1.display();
        Meter m2 = new Meter();
        m2.read();
        m2.display();
        Meter add = new Meter();
        add = m1.add(m2);
        add.display(); 

    }
}