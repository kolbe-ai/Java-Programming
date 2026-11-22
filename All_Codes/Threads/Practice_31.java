//31. Print a number’s multiplication table and the squares of numbers using two threads.

class Square extends Thread{
    int num;
    Square(int n){
        this.num = n;
    }
    public void run(){
        for (int i=1 ; i<= num ; i++){
            System.out.printf("\n[Square] %d x %d = %d",i,i,(i*i));
        }
    }
}

class Multiplication extends Thread{
    int num;
    Multiplication(int num){
        this.num = num;
    }
    public void run(){
        for(int i = 1; i<= 10; i++){
            System.out.printf("\n[Multiplication] %d x %d = %d",num,i,(num*i));
        }
    }
}

public class Practice_31{
    public static void main(String[] args){
        Square sq = new Square(5);
        Multiplication mul = new Multiplication(10);
        sq.start();
        mul.start();
    }
}