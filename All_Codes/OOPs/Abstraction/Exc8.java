/*
Create Shape (with area()), then Circle and Square extending it. 
Store them in a Shape[] array and call area() in a loop.
*/

abstract class Shape{
    abstract void area(float side);
}

class Circle extends Shape{
    void area(float radius){
        System.out.printf("\n\nArea of circle is: %.2f",(3.14*Math.pow(radius,2)));
    }
}
class Square extends Shape{
    void area(float side){
        System.out.printf("\n\nArea of the square is: %.2f\n",(side*side));
    }
}

public class Exc8{
    public static void main(String[] args){
        Circle c1 = new Circle();
        Square s1 = new Square();
        c1.area(14);
        s1.area(20);
        Shape[] shape = {c1,s1};
        for (int i = 0 ; i!=shape.length ; i++){
            shape[i].area(10);
        }

    }
}