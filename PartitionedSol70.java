import java.util.Scanner;

public class PartitionedSol70 {

	public static int[] a = new int[30];
	public static int cnt;
	
	public static int min(int a, int b){
		return a > b ? b : a;
	}
	
	public static void solve(int n, int k) {
		if (n==0){
			for (int i = 0; i < cnt; i++)
				System.out.print(a[i]+" ");
			System.out.println("");
			return;
		}
		for (int i = min(n,k); i >=1; i--){
			a[cnt++]=i;
			solve(n-i, i);
			cnt--;
		}	
	}
	
	public static void main(String[] args) {
		
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		solve(n, n);
		
		return;
	}
}
