//12. Create a Laptop class and compare the prices of two laptops.

class Laptop{
    float price;
    Laptop(float price){
        this.price = price;
    }

    Laptop compare_price(Laptop other){
        if(this.price > other.price){
            return this;
        }else if (this.price < other.price){
            return other;
        }else{
            System.out.println("\nBoth Laptop have same price");
            return null;
        }
    }
}

public class Practice_12{
    public static void main(String[] args){
        Laptop l1 = new Laptop(54000);
        Laptop l2 = new Laptop(55000);
        Laptop l3 = l1.compare_price(l2);
        if ( l3 == l1){
            System.out.println("Laptop 1 is higher in price");
        }else if (l3 == l2){
            System.out.println("Laptop 2 is higher in price");
        }else{
            System.out.println("Both Laptop have same price!");
        }
    }
}