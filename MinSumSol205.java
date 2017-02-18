// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class MinSumSol205 {
	public static final int INF = 987654321;
	
	public static int[][] m = new int[21][21];
	public static int bit, n;
	public static int[] DT = new int[1<<20];

	public static void input(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++)
			for (int j = 0; j< n; j++)
				m[i][j]=sc.nextInt();
		sc.close();
		return;
	}
	
	public static int min(int a, int b){
		return a > b ? b : a;
	}
	
	public static int f(int row, int bit){
		if (row==n)
			return 0;
		if (DT[bit]==0){
			DT[bit]=INF;
			for (int i = 0; i < n; i++)
				if ((bit&(1<<i))==0)
					DT[bit]=min(DT[bit], f(row+1, bit+(1<<i))+m[row][i]);
		}
		return DT[bit];
	}
	
	public static void main(String[] args){
		input();
		System.out.println(f(0,0));
		return;
	}
}
