//11. Create a Water Bill calculator class based on units consumed.
class WaterBill{
    int unit;
    float price=0; 
    void bill_calculator(int unit){
        if(unit>200){
            price = unit*150;          //150rs per unit
        }else if (unit>100){
            price = unit*100;        //100rs per unit
        }else if (unit>50){
            price = unit*50;             //50rs per unit 
        }

        System.out.println("Price is: "+price);
    }
}

public class Practice_11{
    public static void main(String[] args){
        WaterBill w1 = new WaterBill();
        w1.bill_calculator(200);
    }
}