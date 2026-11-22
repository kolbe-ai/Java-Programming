/*
Develop a Teacher Payroll System that calculates gross and net salary from basic pay, DA, HRA and deductions.
*/

class Payroll{
    float gross, net_salary,basic_pay, da, hra, deductions,net_sal;
    Payroll(float basic_pay, float da, float hra, float deductions){
        this.basic_pay = basic_pay;
        this.da = da;
        this.hra = hra;
        this.deductions = deductions;
    }
    void calculate_sal(){
        gross = basic_pay+da+hra;
        net_sal = gross - deductions;
    }
    void display(){
        System.out.printf("\n\nNet salary: %.2f\nGross salary: %.2f\n",net_sal,gross);
    }
}

public class Practice_9{
    public static void main(String[] args){
        Payroll p1 = new Payroll(12345,23,23,13);
        p1.calculate_sal();
        p1.display();
    }
}
