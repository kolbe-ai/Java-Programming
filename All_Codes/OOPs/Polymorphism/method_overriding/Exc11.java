/*
Write a Bank class with the method getInterestRate(), then override it in SBI, HDFC and ICICI. 
Show runtime polymorphism using a parent reference. What is the difference between overloading and overriding?
*/

class Bank{
    void getInterestRate(){
        int base_interest = 7;
        System.out.print("\nBase Interest is: "+base_interest);
    }
}
class SBI extends Bank{
    void getInterestRate(){
        int base_interest = 8;
        System.out.printf("\nInterest is: %d ",base_interest);
    }
}
class HDFC extends Bank{
    void getInterestRate(){
        int base_interest = 9;
        System.out.printf("\nInterest is: %d ",base_interest);
    }
}
class ICICI extends Bank{
    void getInterestRate(){
        int base_interest = 10;
        System.out.printf("\nInterest is: %d ",base_interest);
    }
}

public class Exc11{
    public static void main(String[] args){
        Bank b;
        b = new Bank();
        b.getInterestRate();
        b = new SBI();
        b.getInterestRate();
        b = new HDFC();
        b.getInterestRate();
        b = new ICICI();
        b.getInterestRate();
    }
}