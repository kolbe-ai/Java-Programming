/*
Write an Electricity Bill class where the slab rates are: first 100 units at ₹1.50, next 100 at ₹2.50, 
and above 200 at ₹4.00. Add a fixed charge of ₹50 and print the bill for a given number of units.
*/

class Electricity{
    float price;
    int unit = 0;
    Electricity(int charge){
        this.unit = charge;
    }
    void price(){
        price = 50;
        if(unit>200){
            int phase1 = 100;
            int phase2 = 100;
            int phase3 = unit - 200;
            price += (phase1*1.5) + (phase2*2.5) + (phase3*4);
            System.out.printf("\nThe electricity bill is: %.2f\n",price);
        }else if(unit>100){
            int phase1 = 100;
            int phase2 = unit-100;
            price += (phase1*1.5) + (phase2*2.5);
            System.out.printf("\nThe electricity bill is: %.2f\n",price);
        }else if(unit>=0){
            price += unit*1.5;
            System.out.printf("\nThe electricity bill is: %.2f\n",price);
        }else{
            System.out.println("Error invalid unit");
        }
    }
}

public class Exc7{
    public static void main(String[] args){
        Electricity e1 = new Electricity(101);
        Electricity e2 = new Electricity(201);
        Electricity e3 = new Electricity(301);
        e1.price();
        e2.price();
        e3.price();
    }
}