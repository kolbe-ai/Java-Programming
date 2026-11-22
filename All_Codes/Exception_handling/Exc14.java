/*
Create a custom checked exception InsufficientBalanceException. Throw it from withdraw() and handle it in main. 
What is the difference between throw and throws?
*/


class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}

class Bank1{
    private float bank_balance;
    Bank1(float money){
        this.bank_balance = money;
    }
    void deposit(float money){
        bank_balance += money;
    }
    void withdraw(float money)throws InsufficientBalanceException{
        if (bank_balance - money < 0){
            throw new InsufficientBalanceException("Insufficient Balance!");
        }else{
            bank_balance -= money;
        }
    }
}

public class Exc14{ 
    public static void main(String[] args){
        Bank1 b = new Bank1(1000000);
        b.deposit(9999);
        try{
            b.withdraw(100000000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}