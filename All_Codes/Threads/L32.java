//32. Develop a synchronized ticket booking system.

class ticket_booking{
    synchronized void print(int num){
        System.out.printf("Ticket ID: %d\n",num);
        try{
            Thread.sleep(500);        
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class ticket1 extends Thread{
    ticket_booking A;
    ticket1(ticket_booking a){
        this.A = a;
    }
    public void run(){
        A.print(1);
    }
}

class ticket2 extends Thread{
    ticket_booking A;
    ticket2(ticket_booking a){
        this.A = a;
    }
    public void run(){
        A.print(2);
    }
}

public class L32{
    public static void main(String[] args){
        ticket_booking ticket = new ticket_booking();
        ticket1 t1 = new ticket1(ticket);
        ticket2 t2 = new ticket2(ticket);
        t1.start();
        t2.start();
    }
}