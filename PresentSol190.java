// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class PresentSol190 {

	public static int n, W;
	public static int[] G = new int[21];
	public static int A, B, C;
	public static int ans = 0x7fffffff;
	
	public static boolean[][][] DT = new boolean[2][668][668];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			G[i] = sc.nextInt();
			W+=G[i];
		}
		
		DT[0][0][0] = true;
		for (int i = 1; i <= n; i++)
			for (int a = 0; a<=667; a++)
				for (int b= 0; b<=667; b++)
					DT[i%2][a][b]=(DT[(i-1)%2][a][b] ||
							(a-G[i]<0?false:DT[(i-1)%2][a-G[i]][b] ||
							(b-G[i]<0?false:DT[(i-1)%2][a][b-G[i]])));
		
		for(int a = 0; a <= 667; a++)
			for (int b = 0; b <= 667; b++)
				if(DT[n%2][a][b]) {
					if (W-(a+b)>=a && a>=b &&W-(a+b)-b<=ans){
						ans = W-(a+b)-b;
						A=W-(a+b);
						B=a;
						C=b;
					}
				}
		System.out.println(A+" "+B+" "+C);
		
		sc.close();
		return;
	}
}
