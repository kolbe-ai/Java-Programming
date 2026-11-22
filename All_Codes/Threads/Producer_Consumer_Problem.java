import java.io.*;

class Bank_acc{
    
    static int bank_balance = 20000;
    public synchronized void deposit(int amount){
        bank_balance += amount;
    }
    public synchronized void withdraw(int amount){
        System.out.println("Old Bank balance: "+bank_balance);
        if (bank_balance - amount >= 0){
            bank_balance -= amount;
        }
        System.out.println("New Bank balance: "+bank_balance);
    }
}

class Thread_1 extends Thread{
    Bank_acc b;
    Thread_1(Bank_acc b){
        this.b = b;
    }
    public void run(){
        b.withdraw(2000);
    }
}
class Thread_2 extends Thread{
    Bank_acc b;
    Thread_2(Bank_acc b){
        this.b = b;
    }
    public void run(){
        b.withdraw(2000);
    }
}

class Producer_Con{
    public static void main(String[] args){
        /*
        Bank_acc b= new Bank_acc();
        Thread_1 t1 = new Thread_1(b);
        Thread_2 t2 = new Thread_2(b);
        
        t1.start();
        t2.start();
        */
       try{
        DataInputStream dis = new DataInputStream(System.in);
        String data = dis.readLine();
        int data1 = Integer.parseInt(data);
        System.out.println(data1);
       }catch(Exception e){
        System.out.println(e);
       }
    }
}