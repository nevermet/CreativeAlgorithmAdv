// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class App112 {

	public static int n;
	public static int M;
	public static int[] mem = new int[101];
	public static int[] cost = new int[101];
	public static int[][] dt = new int[101][10001];
	
	public static int max(int a, int b){
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <=n; i++)
			mem[i]=sc.nextInt();
		
		for (int i =1; i <=n; i++)
			cost[i] =sc.nextInt();
		
		sc.close();
	
		int ans = 10001;
		for (int i =1; i <=n; i++){
			for (int j=0; j<=n*100; j++){
				if (cost[i]<=j)
					dt[i][j]=max(dt[i-1][j], dt[i-1][j-cost[i]]+mem[i]);
				else
					dt[i][j]=dt[i-1][j];
				
				if (dt[i][j]>=M && j <=ans)
					ans = j;
			}
		}
		
		System.out.println(ans);
		
/*		for (int i =1; i <=n; i++){
			for (int j = 0; j<=15; j++)
				System.out.print(dt[i][j]+" ");
			System.out.println("");
		}
*/		
		return;
	}

}
