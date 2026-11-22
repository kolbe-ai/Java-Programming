/*
Remove duplicates from {4, 2, 4, 7, 2, 9, 7} without using a Set, keeping the original order.
 */


class Exc{
    public static void main(String[] args){
        int[] arr = {4,2,4,7,2,9,7};
        int[] arr1 = new int[arr.length];
        int pos = 0;
        for (int i = 0 ; i< arr.length ; i++){
            int flag = 0;
            for(int j=0  ; j<arr1.length ; j++){
                if (arr[i] == arr1[j]){
                    flag =1;
                }
            }
            if (flag == 0){
                arr1[pos++] = arr[i];
            }
        }
        for (int i= 0 ; i<arr1.length ; i++){
            System.out.printf("%d ",arr1[i]);
        }
    }
}