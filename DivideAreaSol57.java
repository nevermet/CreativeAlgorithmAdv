import java.util.Scanner;

public class DivideAreaSol57 {

	public static int[][] P = new int[1<<7][1<<7];
	public static int n;
	
	public static boolean isOne(int a, int b, int s, int v) {
		for (int i = a; i < a+s; i++)
			for (int j = b; j < b+s; j++)
				if (P[i][j]!=v)
					return false;
		
		return true;
	}
	
	public static int f(int a, int b, int s, int v) {
		if (s==1)
			return P[a][b]==v?1:0;
		if (isOne(a, b, s, v))
			return 1;
		return f(a,b,s/2,v)
				+f(a+s/2,b,s/2,v)
				+f(a,b+s/2,s/2,v)
				+f(a+s/2,b+s/2,s/2,v);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				P[i][j]=sc.nextInt();
		
		sc.close();
		
		System.out.println(f(0,0,n,0));
		System.out.println(f(0,0,n,1));
		
		return;
	}

}
