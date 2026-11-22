/*
Q25. Create two threads: one prints the multiplication table of 5, the other prints the squares of 1 to 10. 
Do it once with extends Thread and once with implements Runnable. Which is preferred, and why?
*/

class Mul_Thread extends Thread{
    public void run(){
        int num = 5;
        for(int i = 1 ; i<11; i++){
            System.out.printf("%d x %d = %d\n",num,i,(num*i));
        }
        //System.out.println("Hello");
    }
}

class Sqr_Thread implements Runnable{
    public void run(){
        for(int i = 1 ; i<11 ; i++){
            System.out.printf("%d x %d = %d\n",i,i, (i*i));
        }
        
        //System.out.println("Hello");
    }
}

class Exc25{
    public static void main(String[] args){
        Mul_Thread t1 = new Mul_Thread();
        Sqr_Thread s1 = new Sqr_Thread();
        Thread thread1 = new Thread(s1);
        
        t1.start();
        thread1.start();
    }
}
