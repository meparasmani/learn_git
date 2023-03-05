import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
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
		
		sc.close();
		
		boolean res = n==1? false : (divSum==n);
		System.out.println(res);

	}

}
