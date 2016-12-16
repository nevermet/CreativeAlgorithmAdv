import java.util.Scanner;

public class PatrolCarSol173 {

	public static int[][] E = new int[1010][2];
	public static int n, m;
	public static int ans = 0x7fffffff;
	
	public static int min(int a, int b) {
		return  a>b? b: a;
	}
	
	public static int abs(int a) {
		return a > 0 ? a : -a;
	}
	
	public static int dis(int a, int b) {
		return abs(E[a][0]-E[b][0])+abs(E[a][1]-E[b][1]);
	}
	
	public static int f(int a, int b) {
		int next=(a>b?a:b)+1;
		if(next>=m+2)
			return 0;
		return min(f(next, b)+dis(a,next), f(a,next)+dis(b,next));
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		E[0][0]=E[0][1]=1;
		E[1][0]=E[1][1]=n;
		
		for (int i = 2; i<m+2; i++) {
			E[i][0]=sc.nextInt();
			E[i][1]=sc.nextInt();
		}
		sc.close();
		
		System.out.println(f(0,1));
		
		return;
	}
}
