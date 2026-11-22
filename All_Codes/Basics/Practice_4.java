//4. Remove duplicate elements from an array

import java.util.Scanner;
public class Practice_4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        int arr1[] = new int[5];

        for(int i=0; i<arr.length ; i++){
            System.out.printf("\nEnter the number arr[%d]: ",i);
            arr[i] = sc.nextInt();
        }

        int uniq_count =0 ; 
        for(int i = 0; i<arr.length; i++){
            boolean is_dup = false;
            int num = arr[i];
            for(int j=0 ; j< i; j++){
                if(num == arr[j]){
                    is_dup = true;
                    break;
                }
            }
            if(!is_dup){
                arr1[uniq_count++] = num;
            }
        }

        System.out.print("\n\nThe unique array is: ");
        for(int i=0; i<uniq_count ; i++){
            System.out.printf("%d ",arr1[i]);
        }

        

    }
}