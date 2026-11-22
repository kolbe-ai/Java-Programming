/*
Make an abstract Employee class with an abstract method calculateSalary(). Create FullTime and PartTime subclasses. 
Can you create an object of Employee directly? 
*/

abstract class Employee{
    abstract void calculateSalary(float args);
}

class FullTime extends Employee{
    void calculateSalary(float hours){
        float sal = hours * 12345;
        System.out.printf("\nFullTime Salary is: %.3f",sal);
    }
}

class PartTime extends Employee{
    void calculateSalary(float hours){
        float sal = hours*12345;
        System.out.printf("\n\nPartTimeSalary is: %.3f",sal);
    }
}

public class Exc10{
    public static void main(String[] args){
        FullTime f = new FullTime();
        PartTime p = new PartTime();
        f.calculateSalary(9);
        p.calculateSalary(5);
    }
}