//19. Implement a TaxCalculator interface.

import java.util.Scanner;
interface tax_calculator{
	float final_sal(float g_sal,float t_tax);
}

class tax implements tax_calculator{
	float g_sal, t_tax, f_sal;
	public float final_sal(float g_sal,float t_tax){
		this.g_sal = g_sal;
		this.t_tax = t_tax;
		f_sal = g_sal - (g_sal*(t_tax/100));
		return f_sal;
	}
}

public class L19{
	public static void main(String[] args){
		tax_calculator t = new tax();
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the gross sal: ");
		float g_sal = sc.nextFloat();
		System.out.printf("\nEnter the tax percentage: ");
		float t_tax = sc.nextFloat();
		float f_sal = t.final_sal(g_sal,t_tax);
		
		System.out.printf("\nGross salary: %.2f\nTax percentage: %.2f\n\nFinal salary: %.2f",g_sal,t_tax,f_sal);		
	}
}