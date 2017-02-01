import java.util.Scanner;

public class ColorCircleSol138 {

	public static final int MOD = 1000000003;
	
	public static int[][] DT = new int[1001][1001];
	
	public static void main(String[] args){
		
		int n,k;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
		
		for (int i =2; i <=n; i++)
			for (int j=1; j<=n/2; j++)
				if (j==1)
					DT[i][j]=i;
				else
					DT[i][j]=(DT[i-2][j-1]+DT[i-1][j])%MOD;
		
		System.out.println(DT[n][k]);
		
		return;
	}
}
