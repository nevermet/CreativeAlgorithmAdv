import java.util.Scanner;

public class Combination {

	public static int n;
	public static int k;
	
	public static int f(int a) {
		if (a==1)
			return n;
		if (a==n)
			return 1;
		
		return f(a-1)*(n-a+1)/a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
		
		System.out.println(f(k));
		
		return;
	}

}
