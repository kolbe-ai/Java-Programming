//16. Create an abstract Teacher class and derived classes SchoolTeacher and Professor, each calculating salary differently.

abstract class Teacher{
    abstract void calculate_salary(float gross);
}
class SchoolTeacher extends Teacher{
    void calculate_salary(float gross){
        double tax = gross * .12;
        double salary = gross - tax ;              //salary
        System.out.println("Salary of school teacher is: "+salary);             
    }
}
class Professor extends Teacher{
    void calculate_salary(float gross){
        double tax = gross *.13;
        double salary = gross - tax;
        System.out.println("Salary of professor is: "+salary);
    }
}

public class Practice_16{
    public static void main(String[] args){
        SchoolTeacher tr = new SchoolTeacher();
        Professor pr = new Professor();
        tr.calculate_salary(12345);
        pr.calculate_salary(23456);
    }
}