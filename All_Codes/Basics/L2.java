
import java.util.Scanner;
public class L2 {
    public static void main(String[] args){
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int i,j,k;
        for(i = 0; i<row ; i++){        //loops for the number of rows
            for( j = 0 ; j<row-i-1; j++){              //loops for the spaces
                System.out.print(" ");
            }
            int val = 1;
            for(k=0 ; k<=i ; k++){                 //loops for the numbers for each rows
                System.out.print(val+" ");
                val = val* (i-k)/(k+1);
            }
            System.out.println();
        }
    }
}
