//12. Create a Mobile Phone class and compare prices.

import java.util.Scanner;
class Mobile{
    String p_name;
    float price;
    void read(){
        System.out.print("Enter the phone name: ");
        Scanner sc = new Scanner(System.in);
        p_name = sc.nextLine();
        System.out.print("Enter the phone price: ");
        price = sc.nextFloat();
    }
    void display(){
        System.out.printf("Phone: %s\nPrice: %.2f\n\n",p_name,price);
    }
    Mobile comp(Mobile m){
        if(this.price > m.price){
            return this;
        }else{
            return m;
        }
    }
}

public class L12{
    public static void main(String[] args){
        Mobile m1 = new Mobile();
        m1.read();
        m1.display();
        Mobile m2 = new Mobile();
        m2.read();
        m2.display();
        Mobile m3 = new Mobile();
        m3 = m2.comp(m1);
        System.out.printf("\n\nThe %s phone have the highest price with %.2f",m3.p_name,m3.price);
    }
}