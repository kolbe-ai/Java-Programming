class Thread1 extends Thread{
    public void run(){
        for (int i = 0 ; i<10 ; i++){
            System.out.println("Thead 1");

            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }

            Thread.yield();                 // suggestion to the schedulr not sure that another thread will execute;
        }
    }
}

abstract class Animal1{
    abstract void sound();
}
class Dog1 extends Animal1 implements Runnable{
    public void run(){
        for (int i= 0 ; i< 10; i++){
            System.out.println("Boff!"); 
            
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }

            Thread.yield();                 // suggestion to the schedulr not sure that that another thread will execute;
        }
    }
    public void sound(){
    }
}

public class test_thread{
    public static void main(String[] args){
        try{
            Thread1 t1 = new Thread1();
            Thread t2 = new Thread(new Dog1());
            
            t1.start();
            System.out.println("Is thread 1 alive/active: "+t1.isAlive());      //check if the thread is alive now here its true
            t1.join();          //sysnchronize thread need exception
            System.out.println("Is thread 1 alive/active: "+t1.isAlive());      //check if the thread is alive now here its false

            t2.start();
            System.out.println("Name: "+t2.getName());
            t2.setName("Second thread");                        //setting the name
            System.out.println("New name: "+t2.getName());  
            System.out.println("Priority of this thread is: "+t2.getPriority());
            t2.setPriority(10);                         //setting the prority
            System.out.println("New priority of this thread is: "+t2.getPriority());
            System.out.println("Current thread is: "+Thread.currentThread().getName());                   //tells the current thread
            t2.suspend();  // Pause thread
            t2.resume();   // Continue thread
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

/*

# for wait and notify

class MyThread {
    synchronized void print() {
        try {
            System.out.println("Thread is waiting...");

            wait();

            System.out.println("Thread resumed!");
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void wakeUp() {
        notify();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread obj = new MyThread();

        Thread t1 = new Thread(() -> obj.print());

        t1.start();

        Thread.sleep(1000);

        synchronized (obj) {
            obj.notify();
        }
    }
}
 */