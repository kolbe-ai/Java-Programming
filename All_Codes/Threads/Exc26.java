/*
Q26. Write a ticket-booking program with 5 seats and 3 customer threads that all try to book at once. 
Show what goes wrong without synchronized, then fix it.
*/

class Ticket{
    int seat = 5;
    public synchronized int book(){
        if ( seat<=0){
            System.out.println("\n\n|------ HOUSE FULL ------|   \n");
            return 0;
        }
        seat--;
        return 1;
    }
}

class Customer extends Thread implements Runnable{
    Ticket t;
    String name;
    Customer(Ticket t , String name){
        this.t = t;
        this.name = name;
    }

    public void run(){
        int check = t.book();
        if (check == 0){
            System.out.printf("\nThe customer %s NOT booked\n",name);
        }else{
            System.out.printf("\nThe customer %s BOOKED\n",name);
        }
    }

}

class Exc26{
    public static void main(String[] args){
        Ticket t = new Ticket();
        Customer c1 = new Customer(t, "Ravi");
        Customer c2 = new Customer(t, "Rahul");
        Customer c3 = new Customer(t, "Raju");
        Customer c4 = new Customer(t, "Rinu");
        Customer c5 = new Customer(t, "Roni");
        Customer c6 = new Customer(t, "Rom");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();

    }
}