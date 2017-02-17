import java.util.Scanner;

public class SavePrincessSol197 {

	public static final int MOD = 1000;
	
	public static int n;
	public static int[] D = new int[20];
	public static int[] S = new int[20];
	public static int[] A = new int[20];
	public static int[][] DT = new int[20][20];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for (int i = 0; i < n; i++){
			D[i]=sc.nextInt();
			S[i]=sc.nextInt();
			A[i]=sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (i==0 && j==0)
					DT[i][j]=1;
				else if (i!=j || i==n-1 && j==n-1){
					if (i > j){
						for (int k=0; k <i; k++)
							if (D[k]+S[k]>=D[i])
								DT[i][j]+=DT[k][j];
					}
					else if (A[j]>0){
						for (int k =0; k < j; k++)
							if (D[k]+S[j]>=D[j])
								DT[i][j]+=DT[i][k];
					}
				}
				DT[i][j]%=MOD;
			}
		}
		System.out.println(DT[n-1][n-1]);
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++)
				System.out.print(DT[i][j]+" ");
			System.out.println("");
		}
		
		return;
	}
}
