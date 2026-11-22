//31. Print multiplication tables and square numbers using threads.

import java.util.Scanner;

class M_table extends Thread{
    int num;
    M_table(int num){
        this.num = num;
    }
    public void run(){
        System.out.printf("\n|- Multiplication table of %d -|\n",num);
        for(int i = 1 ; i<=num; i++){
            System.out.printf("%d * %d = %d\n",num,i,(num*i));
        }
    }
}

class S_table extends Thread{
    int num;
    S_table(int num){
        this.num = num;
    }
    public void run(){
        System.out.printf("\n\n|- Square table of %d -|\n",num);
        for(int i = 1 ; i<=num ; i++){
            System.out.printf("%d * %d = %d\n",i,i,(i*i));
        }
    }
}


public class L31{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number till you want multiplication and square: ");
        int num = sc.nextInt();
        S_table s = new S_table(num);      //thread 1
        M_table m = new M_table(num);          //thread 2
        s.start();
        m.start();

    }
}