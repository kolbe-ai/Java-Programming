//34. Create a digital clock using threads.

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Clock extends Thread {
    public void run() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {
            System.out.println(LocalTime.now().format(format));
            try {
                Thread.sleep(1000);   // Wait for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class L34 {
        public static void main(String[] args) {
        Clock c = new Clock();
        c.start();
    }
}