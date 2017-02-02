import java.util.Scanner;

public class Change156 {
		
	public static int[] money = new int[10001];
	
	public static void main(String[] args){
		
		int m;
		int n;
		int[] coins = new int[10];

		Scanner sc = new Scanner(System.in);
		m =sc.nextInt();
		n = sc.nextInt();

		for (int i =0; i <=m; i++)
			money[i] = 987654321;
		
		for (int i =0; i<n; i++)
			coins[i]=sc.nextInt();
		
		sc.close();
		
		
		for (int i =n-1; i>=0; i--){
			money[coins[i]]=1;
			for (int j =2; j*coins[i]<=m; j++){
				if (money[j*coins[i]]>money[(j-1)*coins[i]]+1)
					money[j*coins[i]] = money[(j-1)*coins[i]]+1;
			}
		}
		
		System.out.println(money[m]);
		
		return;
	}

}
