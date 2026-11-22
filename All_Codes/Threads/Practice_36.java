//36. Demonstrate thread priorities.

class Thread_ extends Thread{
    String name;
    Thread_(String name){
        this.name = name;
    }
    public void run(){
        System.out.printf("\n\n%s thread priority: %d",name,Thread.currentThread().getPriority());
    }
}

public class Practice_36{
    public static void main(String[] args){
        Thread_ t1 = new Thread_("t1");
        Thread_ t2 = new Thread_("t2");
        t1.setPriority(6);
        t2.setPriority(7);
        t1.start();
        t2.start();
    }
}