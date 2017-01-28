import java.util.Scanner;

public class KnapsackSol111 {

	public static int[][] DT=new int[101][10001];
	public static int[] W = new int[101];
	public static int[] V= new int[101];
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		for (int i = 1; i <=n; i++){
			W[i]=sc.nextInt();
			V[i]=sc.nextInt();
		}
		
		sc.close();
		
		for (int i =n; i >0; i--){
			for (int j = 0; j <=w; j++){
				if (j<W[i])
					DT[i][j]=DT[i+1][j];
				else
					DT[i][j]=max(DT[i+1][j], DT[i+1][j-W[i]]+V[i]);
			}
		}
		System.out.println(DT[1][w]);

		/*
		for (int i =1; i <=n;i++){
			for (int j =0; j<=w; j++)
				System.out.print(DT[i][j]+" ");
			System.out.println("");
		}
		*/
		return;
	}

}
