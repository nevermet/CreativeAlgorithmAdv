// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class PatrolCarSol174 {

	public static int[][] E = new int[1010][2];
	public static int n, m, ans =987654321;
	public static int[][] DT=new int[1100][1100];
	
	public static int min(int a, int b){
		return a > b ? b : a;
	}
	
	public static int abs(int a){
		return a > 0? a:-a;
	}
	
	public static int dis(int a, int b){
		return abs(E[a][0]-E[b][0])+abs(E[a][1]-E[b][1]);
	}
	
	public static int f(int a, int b){
		if (DT[a][b]==0){
			int next = (a > b? a : b)+1;
			if (next > m+1)
				DT[a][b]=0;
			else
				DT[a][b]=min(f(next, b)+dis(a, next), f(a, next)+dis(b, next));
		}
		return DT[a][b];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		E[0][0]=E[0][1]=1;
		E[1][0]=E[1][1]=n;
		
		for (int i =2; i < m+2; i++){
			E[i][0]=sc.nextInt();
			E[i][1]=sc.nextInt();
		}
		sc.close();
		
		System.out.println(f(0,1));
		
		for (int i = 0; i<m+2; i++)
			System.out.println(DT[i][0]+" "+DT[i][1]);
		
		return;
	}
}
