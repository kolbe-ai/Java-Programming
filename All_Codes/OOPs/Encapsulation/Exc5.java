/*
Create an Account class with private fields, getters/setters and a deposit()/withdraw() method. 
Withdrawing more than the balance should print an error. Explain why the fields are private (encapsulation).
*/


class Account{
    private float bank_balance = 123456;

    void deposit(float money){
        bank_balance += money;
    }

    void withdraw(float money){
        if (bank_balance - money < 0){
            System.out.println("Insufficient balance!");
            return;
        }
        bank_balance -= money;
    }
    
    void display(){
        System.out.printf("Account balance is: %.2f",bank_balance);
    }

}

public class Exc5{
    public static void main(String[] args){
        Account acc = new Account();
        acc.deposit(1000);
        acc.withdraw(100);
        acc.display();
    }
}