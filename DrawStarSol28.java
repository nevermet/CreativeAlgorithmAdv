import java.util.Scanner;

public class DrawStarSol28 {

	public static final int MAXN = 10000;
	public static char[] star = new char[MAXN];
	
	public static void f(int n) {
		if (n > 0) {
			f(n-1);
			star[n-1]='*';
			System.out.println(star);
		}
	}
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		f(n);
		
		return;
	}
}
