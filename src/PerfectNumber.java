import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(perfectNumber(n));

	}
	
	public static boolean perfectNumber(int n) {
		
		int divSum=1;
		
		for(int i=2; i*i<=n; i++) {			
			if(n%i == 0) {				
				if(i != n/i) {
					divSum += i +(n/i);
				}				
				else {
					divSum += i;
				}
			}
		}		
		boolean res = n==1? false : (divSum==n);
		
		return res;
	}

}
