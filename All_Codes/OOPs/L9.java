// Develop an Employee Payroll System

import java.util.Scanner;
class Employee{
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    float gross_sal,std_sal, allow, hours, over_time;
    void read(){
        System.out.print("Enter the employee ID: ");
        id = sc.nextInt();
        System.out.print("Enter the employee name: ");
	    name = sc.nextLine(); 		//clear the newline
        name = sc.nextLine();
        System.out.print("Enter the basic salary per hour: ");
        std_sal = sc.nextFloat();
        System.out.print("Enter the number of work hours: ");
        hours = sc.nextFloat();
        System.out.print("Enter the number of overtime work hours: ");
        over_time = sc.nextFloat();
        System.out.print("Enter the allovence: ");
        allow = sc.nextFloat();
        gross_sal = (std_sal*hours)+(std_sal*over_time)+allow;
    }
    void display(){
        System.out.printf("\n\nEmployee: \nEmployee ID: %d \nEmployee name: %s \nEmployee gross salary: %f\n\n",id,name,gross_sal);
    }
}

public class L9{
    public static void main(String[] args){
        Employee e1 = new Employee();
        e1.read();
        e1.display();
        Employee e2 = new Employee();
        e2.read();
        e2.display();
        Employee e3 = new Employee();
        e3.read();
        e3.display();
    }
}