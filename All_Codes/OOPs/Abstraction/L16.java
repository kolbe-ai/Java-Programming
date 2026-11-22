//16. Create an abstract Employee class and derived classes.

abstract class Employee{
    abstract void sal(float sal);
    abstract void disp();
}


class Staff extends Employee{
    float sal;
    void sal(float sal){
        this.sal = sal;
    }
    void disp(){
        System.out.printf("\nEmployee: Staff\nSalary: %.2f\n\n",sal);
    }
}

class Non_staff extends Employee{
    float sal;
    void sal(float sal){
        this.sal = sal;
    }
    void disp(){
        System.out.printf("\nEmployee: Non Staff\nSalary: %.2f\n\n",sal);
    }
}

public class L16{
    public static void main(String[] args){
        Staff s = new Staff();
        s.sal(100000);
        s.disp();
        Non_staff ns = new Non_staff();
        ns.sal(50000);
        ns.disp();
    }
}
