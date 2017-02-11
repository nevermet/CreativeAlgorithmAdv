// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class StoneBridgeSol183 {

	public static char[] rol = new char[30];
	public static char[][] dol = new char[2][120];
	public static int[][] DT = new int[2][30];
	public static int rc;
	
	public static int f(int k){
		
		for(int i = 0; i <dol[1].length;i++){
			for (int t=k-1; t>=0; t--) {
				if (dol[0][i]==rol[t])
					DT[1][t+1]+=DT[0][t];
				if (dol[1][i]==rol[t])
					DT[0][t+1]+=DT[1][t];
			}
			
			for (int l = 0; l<2; l++){
				for (int m = 0; m<=rc; m++)
					System.out.print(DT[l][m]+" ");
				System.out.println("");
			}
			System.out.println("");
			
		}
		return DT[0][k]+DT[1][k];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		rol = sc.next().toCharArray();
		dol[0]=sc.next().toCharArray();
		dol[1]=sc.next().toCharArray();
		sc.close();
		rc = rol.length;
		
		DT[0][0]=1;
		DT[1][0]=1;
		System.out.println(f(rc));
		
		return;
	}
}
