//Sort an array using Selection Sort.
import java.util.Scanner;
import java.util.Arrays;
public class L6 {
    public static void main(String[] args){
        System.out.print("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];

        for(int i=0 ; i<n ; i++){
            System.out.printf("Enter a[%d]: ",i);
            a[i] = sc.nextInt();
        }
        System.out.print("Array : ");
        for(int i = 0; i<n ; i++){
            System.out.print(a[i]+" ");
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = i ; j<n ; j++){
                if(a[i] > a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.print("\n\nSorted Array : ");
        for(int i = 0; i<n ; i++){
            System.out.print(a[i]+" ");
        }
    }
}
