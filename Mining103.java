import java.util.Scanner;

public class Mining103 {
	
	public static int n;
	public static int m;
	public static int[][] arr=new int[200][200];
	public static int[][] dt = new int[200][200];
	
	public static int max(int a, int b){
		return a > b ? a : b;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j]=sc.nextInt();
		
		sc.close();
		
		for (int i = 0; i < n; i++){
			for (int j=0; j<m; j++){
				int up =0;
				int left=0;
				
				if (i>0)
					up = dt[i-1][j];
				
				if (j>0)
					left = dt[i][j-1];
				
				dt[i][j]=max(up, left)+arr[i][j];
			}
		}
		
		System.out.println(dt[n-1][m-1]);
		
		return;
	}

}
