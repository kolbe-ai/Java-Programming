//19. Implement a DiscountCalculator interface with different discount types.

interface DiscountCalculator{
    void discount();
}
class Student_discound implements DiscountCalculator{
    public void discount(){
        System.out.println("\nStudent Discound is: 10%\n");
    }
}
class Staff_discount implements DiscountCalculator{
    public void discount(){
        System.out.println("\nStudent Discound is: 15%\n");
    }
}
public class Practice_19{
    public static void main(String[] args){
        Student_discound std = new Student_discound();
        Staff_discount stff = new Staff_discount();
        std.discount();
        stff.discount();
    }
}