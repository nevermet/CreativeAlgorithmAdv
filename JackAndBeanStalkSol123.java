// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class JackAndBeanStalkSol123 {

	public static int n, m;
	public static int[] p=new int[501];
	public static int[][] DT=new int[501][101];
	
	public static boolean isIn(int a, int b, int k){
		return ((a<=k && k < b) || (b<=k && k < a)) ? true : false;
	}
	
	public static int abs(int a){
		return a > 0? a : -a;
	}
	
	public static void main(String[] args){
		int a, b, X, Y;
		int i, j, k;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		for (i=1; i <=m; i++)
			p[i]=sc.nextInt();
		
		for (i=0; i<=m; i++)
			for (j=0; j<=n; j++)
				DT[i][j]=99999999;
		
		for (j=1; j<=n; j++)
			DT[0][j]=abs(j-a)*Y;
		
		for (i =1; i <=m; i++)
			for (j=1; j<=n; j++)
				for (k=1; k<=n; k++)
					if (j==k && (p[i]==k || p[i]+1==k))
						DT[i][j] = (DT[i-1][k]+X < DT[i][j])?DT[i-1][k]+X:DT[i][j];
					else if (isIn(j,k,p[i]))
						DT[i][j]=DT[i-1][k]+(abs(j-k)-1)*Y < DT[i][j] ? 
								DT[i-1][k]+(abs(j-k)-1)*Y:DT[i][j];
					else
						DT[i][j] = DT[i-1][k]+abs(j-k)*Y < DT[i][j]?
								DT[i-1][k]+abs(j-k)*Y:DT[i][j];
									
		System.out.println(DT[m][b]);
	}
}
