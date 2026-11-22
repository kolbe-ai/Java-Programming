//Find the frequency of each character in a string

import java.util.Scanner;
public class L3 {
    public static void main(String[] args){
        System.out.print("Enter a sentence: ");
        Scanner sc = new Scanner(System.in);
        String sent = sc.nextLine();
        int[] count = new int[256];
        for(int i=0 ; i<sent.length() ; i++){
            char ch = sent.charAt(i);
            count[ch]++;
        }
        for(int i=0 ; i<sent.length() ; i++){
            char ch = sent.charAt(i);
            if(count[ch] == 0 ){
                continue;
            }
            System.out.printf("The number of %c is : %d\n",sent.charAt(i),count[ch]);
            count[ch] = 0;   //avoid the dups
        }
    }
}
