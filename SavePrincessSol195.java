import java.util.Scanner;

public class SavePrincessSol195 {

	public static final int MOD = 1000;
	public static int n;
	public static int[] D = new int[501];
	public static int[] S = new int[501];
	public static int[] A = new int[501];
	
	public static int[][] DT = new int[501][501];
	
	public static int f(int a, int b, int k){
		if (DT[a][b]==-1){
			if (k==n-1)
				return ((D[a]+S[a]>=D[k]) && (D[b]+S[k]>=D[k]))?1:0;
			DT[a][b]=f(a,b,k+1);
			if(D[a]+S[a]>=D[k])
				DT[a][b]+=f(k,b,k+1);
			if (D[b]+S[k]>=D[k] && A[k]>0)
				DT[a][b]+=f(a,k,k+1);
			DT[a][b]%=MOD;
		}
		return DT[a][b];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i =0; i < 501; i++)
			for (int j = 0; j<501; j++)
				DT[i][j]=-1;
		
		for (int i =0; i<n; i++){
			D[i]=sc.nextInt();
			S[i]=sc.nextInt();
			A[i]=sc.nextInt();
		}
		sc.close();
		
		System.out.println(f(0,0,1));
		
		return;			
	}
}
