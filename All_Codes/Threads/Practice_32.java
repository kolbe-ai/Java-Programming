//32. Develop a synchronized movie ticket booking system.

class Ticket extends Thread{
    static int count = 1;
    public synchronized void run(){
        synchronized (Ticket.class){
            if ( count == 0){
                System.out.println("Sorry ticket is sold out!");
            }else{
                count--;
                System.out.println("You got you ticket "+ getName());
            }
        }
    }
}

public class Practice_32{
    public static void main(String[] args){
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        t1.start();
        t2.start();
    }
}