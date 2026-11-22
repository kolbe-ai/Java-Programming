//3. Find the frequency of each character in a string.

import java.util.Scanner;
public class Practice_3{
    public static void main(String[] args){
        System.out.print("Enter a sentence: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for(int i = 0 ; i<line.length() ; i++){
            char c = line.charAt(i);
            boolean already_count = false;

            for (int j =0 ; j<i; j++){
                char c1 = line.charAt(j);
                if(c == c1){
                    already_count = true;
                }
            }

            int count = 0 ; 
            if(!already_count){
                for(int k = 0 ; k<line.length(); k++){
                    char current = line.charAt(k);
                    if (current == c){
                        count++;
                    }
                }
                System.out.printf("\nNumber of count of %c is: %d",c,count);
            }
        }
    }
}