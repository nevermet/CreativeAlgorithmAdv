// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class TofuCutSol209 {

	public static int[][] chk = new int[20][20];
	public static int[][] P = new int[][]{
		{100,70,40,0,0,0}, {70,50,30,0,0,0}, {40,30,20,0,0,0}, 
		{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0}
		};
	public static int n;
	public static char[][] A = new char[20][20];
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int f(int a, int b){
		int ans = 0;
		if (a==n)
			return 0;
		if (b==n)
			return f(a+1, 0);
		if (chk[a][b]==0){
			chk[a][b]=1;
			if (b+1<n && chk[a][b+1]==0) {
				chk[a][b+1]=1;
				ans = max(ans, f(a,b+1)+P[A[a][b]-'A'][A[a][b+1]-'A']);
				chk[a][b+1]=0;
			}
			if(a+1<n && chk[a+1][b]==0){
				chk[a+1][b]=1;
				ans=max(ans,f(a,b+1)+P[A[a][b]-'A'][A[a+1][b]-'A']);
				chk[a+1][b]=0;
			}
			ans=max(ans, f(a,b+1));
			chk[a][b]=0;
		}
		else
			ans = max(ans, f(a,b+1));
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++)
			A[i]=sc.next().toCharArray();
		sc.close();
		System.out.println(f(0,0));
		return;
	}

}
