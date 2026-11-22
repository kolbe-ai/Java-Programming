/*
Q13. Create an interface TaxCalculator with calculateTax(double income). 
Implement it in IndividualTax and CorporateTax with different rates. 
Why can a class implement multiple interfaces but extend only one class?
*/

interface TaxCalculator{
    void calculateTax(double income);
}

class IndividualTax implements TaxCalculator{
    public void calculateTax(double income){
        float tax = 5;
        System.out.printf("\n\nThe tax of the individual is: %.2f",(income *tax/100));
    }
}

class CorporateTax implements TaxCalculator{
    public void calculateTax(double income){
        float tax = 10;
        System.out.printf("\n\nThe tax of the Corpate is: %.2f",(income *tax/100));
    }
}

public class Exc13{
    public static void main(String[] args){
        IndividualTax person = new IndividualTax();
        CorporateTax corporate = new CorporateTax();
        person.calculateTax(12345);
        corporate.calculateTax(1234567890);

    }
}