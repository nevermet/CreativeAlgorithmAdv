import java.util.Scanner;

public class MaxSumSol148 {

	public static final int INF = 987654321;
	
	public static int[] S = new int[100000];
	public static int n, ans =-INF;
	public static int[] DT = new int[100000];
	
	public static int max(int a, int b){
		return a > b ? a :b;
	}
	
	public static int f(int k){
		if (k==0)
			DT[k]=S[0];
		else if (DT[k]==0)
			DT[k]=max(DT[k-1]+S[k], S[k]);
		return DT[k];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i =0; i< n; i++)
			S[i]=sc.nextInt();
		
		sc.close();
		
		for (int i = 0; i < n; i++)
			ans = max(ans, f(i));
		
		System.out.println(ans);
				
		return;
	}
}
