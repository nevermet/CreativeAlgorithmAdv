// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

import java.util.Scanner;


public class ReverseNumSol84 {

	public static int[] DT= new int[50001];
	
	public static int log10(int n){
		
		int i;
		for (i=0; n/10>0;i++)
			n/=10;
		
		return i-1;
	}
	
	public static int pow(int a, int b){
		int i;
		for (i=0; i <b; i++)
			a*=10;
		
		return a;
	}

	public static void main(String[] args) {
		
		int n, i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		sc.close();
		
		for (i =1; i<=n; i++){
			if (i <10)
				DT[i]=i;
			else
				DT[i]=DT[i/10]+(i%10)*(int)pow(10,(int)log10(i));
		}
		System.out.println(DT[n]);

		return;
	}

}
