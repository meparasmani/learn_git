import java.util.Arrays;
import java.util.Scanner;

public class SwappingMinMax {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int b[] = {1, 2, 6, 5, 1, 2};
		//int a[] = {3, 4, 3, 2, 2, 5};
		
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		System.out.println("Elements of arrar a[]: ");
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Elements of arrar b[]: ");
		for(int i=0; i<n; i++) {
			b[i] = sc.nextInt();
		}
		
		sc.close(); 
		System.out.println(minMax(a,b));
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));
	}
	
	public static int minMax(int a[], int b[]) {
		
		int maxA_ind = 0;
		int maxB_ind = 0;
		
		int n = a.length;
		
		for(int i=1; i<n; i++) {
			if(a[i]>a[maxA_ind]) {
				maxA_ind = i;
			}
			
			if(b[i]>b[maxB_ind]) {
				maxB_ind = i;
			}
		}
		
		int res = 0;
		
		// if index of greatest element of both array is same then swap is not possible.
		if(maxA_ind == maxB_ind) {	
			return a[maxA_ind]*b[maxB_ind];
		}
	
		if(b[maxB_ind] <= a[maxA_ind]) {
			int b_max = 0; // new max element
			for(int i=0; i<n; i++) {
				if(a[i]<b[i] && b[i]>b_max) {
					swap(a,b,i);
				}
				b_max= b[i]>b_max?b[i]:b_max;
			}
			res = a[maxA_ind]*b_max;
		}
		
		else {
			int a_max = 0; // new index of max element 			
			for(int i=0; i<n; i++) {
				if(a[i]>b[i] && a[i]>a_max) {
					swap(a,b,i);
				}
				a_max= a[i]>a_max?a[i]:a_max;
			}			
			res = a_max*b[maxB_ind];
		}	
		
		return res;
	}
	
	public static void swap(int a[], int b[], int i) {
		int t = a[i];
		a[i] = b[i];
		b[i] = t;
	}

}
