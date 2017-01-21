import java.util.Scanner;

public class Combination87 {

	public static int n, k;
	public static int[][] DT = new int[31][31];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		sc.close();
		
		for (int i = 1; i<=n; i++){
			for (int j=1; j<=i && j<=k; j++){
				if (j==1)
					DT[i][j] = i;
				else if (i==j)
					DT[i][j]=1;
				else
					DT[i][j]=DT[i-1][j]+DT[i-1][j-1];
			}
		}
		System.out.println(DT[n][k]);
		
		return;
	}

}
