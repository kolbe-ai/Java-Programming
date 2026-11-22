//10. Create a Length class (feet and inches) and add two lengths.

class Length{
    float feet;
    float inches;
    Length(float feet, float inches){
        this.feet = feet;
        this.inches = inches;
    }
    Length add(Length other){
        float new_inches = (other.inches + this.inches)%12;
        float new_feet = other.feet+this.feet+(other.inches + this.inches)/12;
        return new Length(new_feet,new_inches);
    }
    void display(){
        System.out.printf("\n\nFeet: %.2f\nInches: %.2f\n",feet,inches);
    }
}

public class Practice_10{
    public static void main(String[] args){
        Length l1 = new Length(10,5);
        Length l2 = new Length(12,9);
        Length l3 = l1.add(l2);
        l3.display();
    }
}