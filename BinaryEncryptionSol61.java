// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class BinaryEncryptionSol61 {

	public static char[] S = new char[1<<19];
	public static int n;
	
	public static void f(int k, int s) {
		int sum = 0;
		if (s==1) {
			System.out.print(S[k]);
			return;
		}
		
		for (int i = k; i < k+s; i++)
			sum += (S[i]-'0');
		
		if (sum == 0 || sum == s)
			System.out.print(sum/s);
		else {
			System.out.print("-");
			f(k, s/2);
			f(k+s/2, s/2);
		}			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		S = sc.next().toCharArray();
		sc.close();
		f(0, n);
		return;
	}

}
