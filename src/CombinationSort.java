import java.util.Arrays;

public class CombinationSort {

	public static void main(String[] args) {
		
		String st[] = {"d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77"};	
		int h = st.length;
		
		String st1[] = new String[h];
		for(int i=0; i<h; i++) {
			st1[i]=st[i];
		}
		
		mergeAS(st,0,h-1);
		mergeAD(st1,0,h-1);
		
		System.out.println(Arrays.toString(st));
		System.out.println(Arrays.toString(st1));
	}
	
	public static void mergeAD(String st[], int l, int h) {
		if(h>l) {
			int m = (l+h)/2 ;
			
			mergeAD(st,l,m);
			mergeAD(st,m+1,h);
			mergeAscDesc(st,l,m,h);
		}
	}
	
	public static void mergeAS(String st[], int l, int h) {
		if(h>l) {
			int m = (l+h)/2 ;
			//System.out.println("M : "+m);
			mergeAS(st,l,m);
			mergeAS(st,m+1,h);
			mergeAscStable(st,l,m,h);
		}
	}
	
	public static void mergeAscDesc(String st[], int l, int m, int h) {
		String[][] l_r_array = arraySplit(st,l,m,h);
		
		//Merging left and right array
		int i=l, p1=0, p2=0;
		int n1 = l_r_array[0].length; // length of left array
		int n2 = l_r_array[1].length; // length of right array
		
		while(p1<n1 && p2<n2) {
			char ch1 = l_r_array[0][p1].charAt(0);// char of left array
			char ch2 = l_r_array[1][p2].charAt(0); //char of right array
			
			if(Character.compare(ch1, ch2)<0) {
				st[i] = l_r_array[0][p1];
				i++;
				p1++;
			}
			else if(Character.compare(ch1, ch2)==0) {
				int val1 = Integer.parseInt(l_r_array[0][p1].substring(1));
				int val2 = Integer.parseInt(l_r_array[1][p2].substring(1));
				
				if(val1>val2) {
					st[i] = l_r_array[0][p1];
					i++;
					p1++;
				}
				
				else {
					st[i] = l_r_array[1][p2];
					i++;
					p2++;
				}
			}
			else {
				st[i] = l_r_array[1][p2];
				i++;
				p2++;
			}
		}
		
		while(p1<n1) {
			st[i] = l_r_array[0][p1];
			i++;
			p1++;
		}
		
		while(p2<n2) {
			st[i] = l_r_array[1][p2];
			i++;
			p2++;
		}
		
	}
	
	public static void mergeAscStable(String st[], int l, int m, int h) {
		String[][] l_r_array = arraySplit(st,l,m,h); // getting left and right array		
		//Merging left and right array
		int i=l, p1=0, p2=0;
		int n1 = l_r_array[0].length; // length of left array
		int n2 = l_r_array[1].length; // length of right array
		
		while(p1<n1 && p2<n2) {
			char ch1 = l_r_array[0][p1].charAt(0);// char of left array
			char ch2 = l_r_array[1][p2].charAt(0); //char of right array
			
			if(Character.compare(ch1, ch2)<=0) {
				st[i] = l_r_array[0][p1];
				i++;
				p1++;
			}
			
			else {
				st[i] = l_r_array[1][p2];
				i++;
				p2++;
			}
		}
		
		while(p1<n1) {
			st[i] = l_r_array[0][p1];
			i++;
			p1++;
		}
		
		while(p2<n2) {
			st[i] = l_r_array[1][p2];
			i++;
			p2++;
		}
		
	}
	
	public static String[][] arraySplit(String st[], int l, int m, int h){
		int n1 = m-l+1;
		int n2 = h-m;
		
		String left[] = new String[n1];
		for(int i=0; i<n1; i++) {
			left[i] = st[l+i] ;
		}
		
		String right[] = new String[n2];
		for(int i=0; i<n2; i++) {
			right[i] = st[m+i+1];
		}
		
		String res[][] = {left, right};
		
		return res;
	}
}
