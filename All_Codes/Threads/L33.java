//33. Implement Producer-Consumer problem.

class Buffer{
    int item;
    int available = 0;
    synchronized void producer(int num) throws InterruptedException{
        while(available == 1){
            wait();
        }
        item = num;
        available = 1;
        System.out.printf("Produce produced: %d\n",num);
        notify();
    }

    synchronized void consumer() throws InterruptedException{
        while(available == 0){
            wait();
        }
        System.out.printf("Consumer consumed: %d\n",item);
        available = 0;
        notify();
    }
}

class Producer extends Thread{
    Buffer b;
    Producer(Buffer b){
        this.b = b;
    }
    public void run(){
        try{
            for(int i = 0; i<10; i++){
                b.producer(i);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class Consumer extends Thread{
    Buffer b;
    Consumer(Buffer b){
        this.b = b;
    }
    public void run(){
        try{
            for(int i =0 ; i<10; i++){
                b.consumer();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class L33{
    public static void main(String[] args){
        Buffer b = new Buffer();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);
        p.start();
        c.start();
    }
}