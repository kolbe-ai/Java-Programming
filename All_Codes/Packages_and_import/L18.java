//18. Create a package containing mathematical operations.

import java.util.Scanner;

abstract class math_op{
    abstract void operation(float num1, float num2);
    abstract void result();
}

class Addition extends math_op{
    float result;
    float num1,num2;
    void operation(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1+num2;
    }
    void result(){
        System.out.printf("%.2f + %.2f = %.2f\n",num1,num2,result);
    }
}

class Subtraction extends math_op{
    float result;
    float num1,num2;
    void operation(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1-num2;
    }
    void result(){
        System.out.printf("%.2f - %.2f = %.2f\n",num1,num2,result);
    }
}
class Multi extends math_op{
    float result;
    float num1,num2;
    void operation(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1*num2;
    }
    void result(){
        System.out.printf("%.2f x %.2f = %.2f\n",num1,num2,result);
    }
}
class Div extends math_op{
    float result;
    float num1,num2;
    void operation(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1/num2;
    }
    void result(){
        System.out.printf("%.2f / %.2f = %.2f\n",num1,num2,result);
    }
}
class Pow extends math_op{
    float result;
    float num1,num2;
    void operation(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        result = (float)Math.pow(num1,num2);
    }
    void result(){
        System.out.printf("%.2f ^ %.2f = %.2f\n",num1,num2,result);
    }
}

public class L18{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter the number 1: ");
            float num1 = sc.nextFloat();
            System.out.print("Enter the number 2: ");
            float num2 = sc.nextFloat();
            System.out.print("Enter the operation: + - * / ^ : ");
            char ch = sc.next().charAt(0);
            switch(ch){
                case '+':
                    Addition add = new Addition();
                    add.operation(num1,num2);
                    add.result();
                    break;
                case '-':
                    Subtraction sub = new Subtraction();
                    sub.operation(num1,num2);
                    sub.result();
                    break;
                case '*':
                    Multi m = new Multi();
                    m.operation(num1,num2);
                    m.result();
                    break;
                case '/':
                    Div d = new Div();
                    d.operation(num1,num2);
                    d.result();
                    break;
                case '^':
                    Pow p = new Pow();
                    p.operation(num1,num2);
                    p.result();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            int quit;
            System.out.print("|---- Enter 0 to exit ----| : ");
            quit = sc.nextInt();
            if(quit == 0){
                break;
            }
        }
    }
}