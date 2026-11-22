//Remove duplicate elements from an array
import java.util.Scanner;
public class L5 {
    public static void main(String[] args){
        System.out.print("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.printf("Enter a[%d]: ",i);
            a[i] = sc.nextInt();
        }
        System.out.print("The array is: ");
        for(int i=0 ; i<n ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("\n\nThe New array is: ");
        for(int i = 0 ; i<n ; i++) {
            int f = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    f = 1;      //flagging 1 if tis equal
                    break;
                }
            }
            if (f == 0) {    //printing the output if flag = 0
                System.out.print(a[i]+" ");      //printing the output, to save the new array create new array after counting here and assinging
            }
        }

    }
}
