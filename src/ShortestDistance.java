import java.util.Scanner;

public class ShortestDistance {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		int st[] = new int[2];
		
		System.out.println("Enter starting X : ");
		st[0] = sc.nextInt();
		System.out.println("Enter starting Y : ");
		st[1] = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Path String : ");
		String path = sc.nextLine();
		sc.close();
		System.out.format("%.2f", shortDist(st,path));

	}
	
	public static double shortDist(int start[], String path) {
		
		int O_x = start[0];
		int O_y = start[1];
		
		int n = path.length();
		int x=O_x, y=O_y;
		
		for(int i=0; i<n; i++) {
			
			if(path.charAt(i)=='N') {
				y++;
			}
			
			else if(path.charAt(i)=='S') {
				y--;
			}
			
			else if(path.charAt(i)=='E') {
				x++;
			}
			
			else {
				x--;
			}
		}
		
		double dist = Math.sqrt(Math.pow(x-O_x, 2)  + Math.pow(y-O_y, 2));
		return dist;
	}

}
