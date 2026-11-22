// Develop an Employee Payroll System

import java.util.Scanner;
class Electric{
    Scanner sc = new Scanner(System.in);
    float units,charge,total;
    void read(){
        System.out.print("Enter the current charge per unit: ");
        charge = sc.nextFloat(); 
        System.out.print("Enter the number of units: ");
        units = sc.nextFloat();
	total = charge*units;
    }
    void display(){
        System.out.printf("\n\nElectric Charge: \nCurrent charge per unit: %f \nNumber of units: %f \nTotal charage: %f\n\n",charge,units,total);
    }
}

public class L11{
    public static void main(String[] args){
        Electric e1 = new Electric();
        e1.read();
        e1.display();
    }
}