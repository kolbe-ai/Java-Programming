import java.time.LocalTime;

class Clock extends Thread{
    public void run(){
        while(true){
            LocalTime time = LocalTime.now();
            System.out.printf("\n %d: %d: %d", time.getHour(), time.getMinute(), time.getSecond());
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}


public class Practice_35{
    public static void main(String[] args){
        Clock clock = new Clock();
        clock.start();
    }
}