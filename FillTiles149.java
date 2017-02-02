// for more info
// http://softwareeng.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


import java.util.Scanner;

public class FillTiles149 {

	public static int n, m;
	public static int[] DT = new int[100001];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
		
		DT[1]=1;
		DT[2]=3;
		DT[3]=5;
		
		for (int i=4; i <=n; i++){
			if (i%2==0){
				DT[i]=(DT[i/2]*DT[i/2]+DT[i/2-1]*DT[i/2-1]*2)%m;
			}
			else{
				DT[i]=(DT[i/2]*DT[i/2+1]+DT[i/2]*DT[i/2-1]*2)%m;
			}
		}
		System.out.println(DT[n]);
		return;
	}
}
