//Create a Product class with overloaded constructors
import java.util.Scanner;

class Product{
    int pd_id;
    String pd_name;
    float pd_price;
    String exp_date;
    Scanner sc = new Scanner(System.in);
    Product(){
        System.out.print("\n\nEnter the product Details: \n");
        System.out.print("Enter the product ID: ");
        pd_id = sc.nextInt();
        System.out.print("Enter the product name: ");
	sc.nextLine(); 			//taking the left over newline
        pd_name = sc.nextLine();
        System.out.print("Enter the product prize: ");
        pd_price = sc.nextFloat();
        exp_date = "No expiry";
    }
    Product(String veg){
        System.out.print("\n\nEnter the product Details\n: ");
        System.out.print("Enter the product ID: ");
        pd_id = sc.nextInt();
        pd_name = veg;
        System.out.print("Enter the product prize: ");
        pd_price = sc.nextFloat();
        System.out.print("Enter the product expire date: ");
        exp_date = sc.nextLine();
    }
    void display(){
        System.out.printf("\n\nProduct:\nProduct ID: %d \nProduct name: %s \nProduct prize: %f \nProduct expire date: %s\n\n",pd_id,pd_name,pd_price,exp_date);
    }
}

public class L8{
    public static void main(String[] args){
        Product p1 = new Product();
        p1.display();
        Product p2 = new Product("Tomato");
        p2.display();
    }
}