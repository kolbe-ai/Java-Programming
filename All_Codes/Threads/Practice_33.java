//33. Implement Producer-Consumer problem

class New_Buffer{
    static int buffer = 0;
    static int size = 5;
    synchronized void producer(){
        try{
            //wait if full
            while(buffer >=size){
                System.out.println("Producer Waiting....");
                wait();
            }
            System.out.println("Producer producing!");
            buffer++;
            notifyAll();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    synchronized void consumer(){
        try{
            while(buffer<=0){
                System.out.println("Consumer Waiting....");
                wait();
            }
            System.out.println("Consumer consuming!");
            buffer--;
            notifyAll();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


class New_Producer extends Thread{
    New_Buffer buff;
    New_Producer(New_Buffer buff){
        this.buff = buff;
    }
    public void run(){
        for (int i = 0 ; i<10 ; i++){
            buff.producer();
        }
    }
}

class New_Consumer extends Thread{
    New_Buffer buff;
    New_Consumer(New_Buffer buff){
        this.buff = buff;
    }
    public void run(){
        for(int i =0 ; i<10 ; i++){
            buff.consumer();
        }
    }
}

public class Practice_33{
    public static void main(String[] args){
        New_Buffer buff = new New_Buffer();
        New_Producer produce = new New_Producer(buff);
        New_Consumer consume = new New_Consumer(buff);

        produce.start();
        consume.start();
    }
}