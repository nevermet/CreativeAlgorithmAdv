import java.util.Scanner;

public class BinaryDecryptionSol67 {

	public static char[] S = new char[1<<19];
	public static char[] S2 = new char[1<<19];
	public static int n, p;
	public static String str;
	
	public static void f(int k, int s) {
		char val = S[p++];
		if (p==str.length()+1)
			return;
		if (val=='-') {
			f(k, s/2);
			f(k+s/2, s/2);
		}
		else {
			for (int i = k; i < k+s;i++)
				S2[i] = val;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		str = sc.next();
		S = str.toCharArray();
		sc.close();
		f(0, n);
		
		System.out.println(S2);
		

	}

}
