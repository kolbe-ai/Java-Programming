/*
Implement multilevel inheritance: Person (name, age) → Faculty (salary, department) → HOD (the department head’s tenure in years). 
Each class should have a display() method that calls super.display(). 
*/

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    void display(){
        System.out.printf("Name: %s\nAge: %d",name,age);
    }
}
class Faculty extends Person{
    float salary;
    String dept;
    Faculty(String name, int age,float sal, String dept){
        super(name, age);
        this.salary = sal;
        this.dept = dept;
    }
    void display(){
        super.display();
        System.out.printf("\nSalary: %.2f\nDepartment: %s",salary,dept);
    }
}
class HOD extends Faculty{
    String h_name;
    HOD(String name, int age,float sal, String dept,String h_name){
        super(name, age, sal, dept);
        this.h_name = h_name;
    }
    void display(){
        super.display();
        System.out.printf("\nHOD: %s \nYears: 2008 - 2026\n\n\n",h_name);
    }
}

public class Exc9{
    public static void main(String[] args){
        HOD h1 = new HOD("Hyder",67,102983,"Computer","Hyder");
        h1.display();
    }
}