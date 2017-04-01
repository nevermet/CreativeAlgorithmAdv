import java.util.Scanner;

public class LightFlightSol236 {
	
	static class P{
		public int x;
		public int y;
	}

	public static int N;
	public static int K;
	public static int T;
	public static int[] chk = new int[1002];
	public static int[][] D = new int[1002][1002];
	public static P[] S = new P[12];	
		
	public static boolean f(int t){
		int[] Q = new int[100];
		int qs = 0;
		int qe = 0;
		
		for (int i = 0; i<1002; i++)
			chk[i]=-1;
		
		Q[qe]=0;
		chk[0]=0;
		qe++;
		
		while (qe!=qs){
			int i;
			T = Q[qs];
			qs++;
			
			if (chk[T]>K+1)
				return false;
			else if (T==N+1)
				return true;
			
			for (i =0; i <= N+1; i++){
				if (chk[i]==-1 &&D[T][i]<(t*10)*(t*10)) {
					chk[i]=chk[T]+1;
					Q[qe]=i;
					qe++;
				}
			}
		}
		return false;		
	}
	
	public static void main(String[] args){
		int i, j, lb=0, ub=14142, m;
		//, x, y;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		S[0] = new P();
		S[0].x =S[0].y=0;
		S[N+1] = new P();
		S[N+1].x=S[N+1].y=10000;
		
		for (i =1; i<=N; i++){
			S[i]=new P();
			S[i].x=sc.nextInt();
			S[i].y = sc.nextInt();
		}
		sc.close();
		
		for (i=0; i <=N+1; i++)
			for (j = 0; j<=N+1;j++)
				D[i][j]=
				(S[i].x-S[j].x)*(S[i].x-S[j].x) + (S[i].y-S[j].y)*(S[i].y-S[j].y);
	
		while(lb<ub){
			m=(ub+lb-1)/2;
			if(f(m))
				ub=m;
			else
				lb=m+1;
		}
		
		System.out.println(ub);
		
		return;
	}
}
