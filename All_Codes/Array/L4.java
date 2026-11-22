import java.util.Scanner;
public class L4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter r1: ");
        int r1 = sc.nextInt();
        System.out.print("Enter c1: ");
        int c1 = sc.nextInt();
        System.out.print("Enter r2: ");
        int r2 = sc.nextInt();
        System.out.print("Enter c2: ");
        int c2 = sc.nextInt();
        if(r1 != r2 || c1 != c2){
            System.out.print("The matrixs have different number or rows and column cannot add");
            return;
        }
        int [][] a = new int [r1][c1];
        int [][] b = new int [r2][c2];
        System.out.println("\n\nINPUT MATRIX 1:");  //inserting matrix 1
        for(int i = 0 ; i<r1; i++){
            for(int j =0; j<c1 ; j++) {
                System.out.printf("Enter a[%d][%d]: ", i, j);
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("\n\nINPUT MATRIX 2:");  //inserting matrix 1
        for(int i = 0 ; i<r1; i++){
            for(int j =0; j<c1 ; j++) {
                System.out.printf("Enter b[%d][%d]: ", i, j);
                b[i][j] = sc.nextInt();
            }
        }
        System.out.println("\n\nMATRIX 1:");
        for(int i = 0 ; i<r1; i++){
            for(int j =0; j<c1 ; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\n\nMATRIX 2:");
        for(int i = 0 ; i<r1; i++){
            for(int j =0; j<c1 ; j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("\n\nADDED MATRIX:");
        int c[][] = new int[r1][c1];
        for(int i = 0 ; i<r1; i++){
            for(int j =0; j<c1 ; j++){
                c[i][j] = a[i][j] + b[i][j];     //adding of matrix
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }


    }

}
