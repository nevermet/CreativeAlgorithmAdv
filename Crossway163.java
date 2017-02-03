// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;

public class Crossway163 {

	public static int n, m;
	public static int[][] dt = new int[101][101];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
		
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++){
				if (i ==0 && j==0)
					dt[i][j]=1;
				else{
					if (i*m >= j*n && j >0)
						dt[i][j]+=dt[i][j-1];
					if ((i-1)*m >= j*n && i>0)
						dt[i][j]+=dt[i-1][j];
				}	
			}
		
		System.out.println(dt[n][m]);
/*		
		for (int i = 0; i <=n; i++) {
			for (int j =0; j <=m; j++){
				System.out.print(dt[i][j]+" ");				
			}
			System.out.println("");
		}
*/		
		return;
	}

}
