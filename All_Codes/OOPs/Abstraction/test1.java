import java.util.Scanner;

//static
class Demo{
    static{
        System.out.println("Hi fro static");
    }
    static void hello(){
        System.out.println("Hello");
    }
}


//inheritance
class Animal{
    String name = "Idk";
    Animal(){
        System.out.println("Animal make sounds!");
    }
    void sound(){
        System.out.println("Animal sound!");
    }
}
class Dog extends Animal{
    String name = super.name;       //super variable
    Dog(){
        super();           //super constructor
    }
    @Override
    void sound(){
        System.out.println("Buff!!");
        System.out.println(super.name);     //super variable
        super.sound();      //super method
    }
}


//abstraction
abstract class Dept{
    abstract void name();
    void uni(){
        System.out.println("XYZ");
    }
}
class Teacher extends Dept{
    void name(){
        System.out.println("Name");
        super.uni();
    }
}


//interface
interface Wolf{
    int num = 10;       //public static final
    void sound();       //public static abstract
}
class Wolf_pack implements Wolf{
    public void sound(){        //should be public 
        System.out.println();
        System.out.println("Wooff wooff!");
    }
}


//encapsulation
class Bank{
    private int balance;
    //use getter
    int get(){
        return balance;
    }
    //use setter
    void set(int num){
        this.balance = num;
    }
}


//call by referece
class Num{
    int x = 1;
    int y = 2;
}


//Custom Error class
class AgeException extends Exception{
    AgeException(String message){
        super(message);
    }
}



public class test1{
    public static void main(String[] args){
        int a[] = {1,2,3,4};
        for(int x:a){
            System.out.println(x);
        }
        Teacher t = new Teacher();
        t.name();
        Wolf_pack w = new Wolf_pack();
        w.sound();
        
        //call by reference
        Num n = new Num();
        change(n);

        //encapsulation;
        Bank b = new Bank();
        b.set(1000);
        System.out.println(b.get());

        //exception
        try{
            age(17);
        }catch(AgeException e){
            System.out.printf("\n\nError: %s",e.getMessage());
        }

    }
    
    //call by value change
    static void change(Num n){
        int temp = n.x;
        n.x = n.y;
        n.y = temp;
        System.out.printf("\nX = %d\nY = %d\n",n.x,n.y);
    }

    //creating custom exception
    static void age (int age) throws AgeException{
        if (age<18){
            throw new AgeException("Under Age");
        }
    }


}