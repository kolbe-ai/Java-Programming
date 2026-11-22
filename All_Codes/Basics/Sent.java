import java.util.Scanner;
public class Sent{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String palin = scn.nextLine();
		int n = palin.length() -1;
		int f = 1;
		for(int i = 0 ; i<= n ; i++){
			if(palin.charAt(i) == palin.charAt(n)){
				f = 1;				
			}else{
				f = 0;
				break;
			}
			n--;
		}
		if (f ==1){
			System.out.println("The String "+palin+" is palindrome");
		}else{
			System.out.println("The String "+palin+" is not palindrome");
		}
	}
}