// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class FillTilesSol45 {

	public static int n;
	public static int m;
		
	public static long f(int k) {
		if (k<=1)
			return 1%m;
		else if (k%2>0)
			return (f(k/2)*f(k/2+1)+2*f(k/2)*f(k/2-1))%m;
		else
			return (f(k/2)*f(k/2)+2*f(k/2-1)*f(k/2-1))%m;
	}
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
			
		System.out.println(f(n));
			
		return;
	}

}
