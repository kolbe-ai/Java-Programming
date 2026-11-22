//Create a Product class with overloaded constructors
import java.util.Scanner;

class Product{
    int pd_id;
    String pd_name;
    float pd_price;
    String exp_date;
    Product(int id,String name, float price){
        this.pd_id = id;
	this.pd_name = name;
	this.pd_price = price;
        this.exp_date = "No expiry";
    }
    Product(int id,String name, float price, String exp_date){
	this.pd_id = id;
	this.pd_name = name;
	this.pd_price = price;
        this.exp_date = exp_date;        
    }
    void display(){
        System.out.printf("\n\nProduct:\nProduct ID: %d \nProduct name: %s \nProduct prize: %f \nProduct expire date: %s\n\n",pd_id,pd_name,pd_price,exp_date);
    }
}

public class new_L8{
    public static void main(String[] args){
	int pd_id;
	String pd_name;
	float pd_price;
	String exp_date;
	Scanner sc = new Scanner(System.in);

	System.out.print("\n\nEnter the product Details: \n");
        System.out.print("Enter the product ID: ");
        pd_id = sc.nextInt();
        System.out.print("Enter the product name: ");
	sc.nextLine(); 			//taking the left over newline
        pd_name = sc.nextLine();
        System.out.print("Enter the product prize: ");
        pd_price = sc.nextFloat();

        Product p1 = new Product(pd_id,pd_name,pd_price);

        p1.display();
        

	
	System.out.print("\n\nEnter the product Details\n: ");
        System.out.print("Enter the product ID: ");
        pd_id = sc.nextInt();
        System.out.print("Enter the product name: ");
	sc.nextLine(); 			//taking the left over newline
        pd_name = sc.nextLine();

        System.out.print("Enter the product prize: ");
        pd_price = sc.nextFloat();
        System.out.print("Enter the product expire date: ");
	sc.nextLine(); 			//taking the left over newline
        exp_date = sc.nextLine();

	Product p2 = new Product(pd_id,pd_name,pd_price,exp_date);

        p2.display();
    }
}