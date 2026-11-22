//Q12. Create a class Mymath (add, subtract, multiply, divide). 
class Mymath{
    public static void add(int num1,int num2){
        System.out.printf("\n %d + %d = %d",num1,num2,(num1+num2));
    }
    public static void sub(int num1,int num2){
        System.out.printf("\n %d - %d = %d",num1,num2,(num1-num2));
    }
    public static void mul(int num1,int num2){
        System.out.printf("\n %d x %d = %.2f",num1,num2,(num1*num2));
    }
    public static void div(int num1,int num2){
        System.out.printf("\n %d / %d = %.2f",num1,num2,(num1/num2));
    }

}