// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class ClimbingSol231 {

	public static int N;
	public static int[][] M = new int[511][511];
	public static boolean[][] chk= new boolean[511][511];
	public static int[] dx = new int[]{0,1,0,-1};
	public static int[] dy = new int[]{1,0,-1,0};
	public static int lb, ub, m;
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int abs(int a){
		return a > 0 ? a : -a;
	}
	
	public static boolean can(int a, int b){
		return (0<=a && a<N) && (0<=b && b < N);
	}
	
	public static int dfs(int a, int b, int h){
		int area = 1;
		chk[a][b]=true;
		for (int i = 0; i < 4; i++)
			if (can(a+dx[i], b+dy[i]) && !chk[a+dx[i]][b+dy[i]] &&
			abs(M[a][b]-M[a+dx[i]][b+dy[i]])<=h)
				area+=dfs(a+dx[i],b+dy[i],h);
			
		return area;
	}
	
	public static boolean f(int h){
		int mcnt=0, cnt;
		for (int i =0; i< N/2+1; i++)
			for (int j = 0; j < N/2+1; j++)
				if (!chk[i][j]){
					cnt = dfs(i, j, h);
					mcnt = max(cnt, mcnt);
				}
		return (mcnt >= (int)(N*N*0.75));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++){
				M[i][j]=sc.nextInt();
				ub = max(ub, M[i][j]);
			}

		sc.close();
		while (lb<ub){
			for (int i = 0; i < 511; i++)
				for (int j = 0; j < 511; j++)
					chk[i][j]=false;
			
			m = (lb+ub+1)/2;
			if (f(m))
				ub = m;
			else
				lb=m+1;
		}
		
		System.out.println(ub);
		return;
	}
}
