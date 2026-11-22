/*
Q6. Create a Rectangle class with three constructors: no-argument (default 1×1), one argument (square) and two arguments. Add an area() method. 
Which OOP concept is this, and how does Java decide which constructor to call?
*/

//ANSWER:

/* 
this is a construction overloading or polymorphism in OOPs which says it can have many forms
Java decide which constructor to call in compile time */


class Rectangle{
    int length;
    int bredth;
    Rectangle(){
        length = 1;
        bredth = 1;
    }
    Rectangle(int side){
        this.length = side;
        this.bredth = side;
    }

    Rectangle(int length, int bredth){
        this.length = length;
        this.bredth = bredth;
    }
    
    void area(){
        System.out.println("Area of the rectangle is: "+(length*bredth));
    }
}

public class Exc6{
    public static void main(String[] args){
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10);
        Rectangle r3 = new Rectangle(20,10);
        r1.area();
        r2.area();
        r3.area();

    }
}
