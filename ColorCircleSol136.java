import java.util.Scanner;

public class ColorCircleSol136 {

	public static final int MOD = 1000000003;
	
	public static int f(int n, int k) {
		if (k>n/2)
			return 0;
		else if (k==1)
			return n;
		else 
			return (f(n-2, k-1)+f(n-1, k))%MOD;
	}
	
	public static void main(String[] args) {
		int n, k;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		sc.close();
		
		System.out.println(f(n,k));
		
		return;
	}
}
