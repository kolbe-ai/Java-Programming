//18. Create a package containing geometry operations (area of circle, rectangle, triangle) and use it from another class.
import geometry.Area;

public class Practice_18{
    public static void main(String[] args){
        Area a = new Area();
        double area = a.circle(7);
        System.out.println("\nArea of Circle is: "+area);
        area = a.rectangle(20,10);
        System.out.println("\nArea of Rectange is: "+area);
        area = a.triangle(10,20);
        System.out.println("\nArea of Triangle is: "+area);
        
    }
}