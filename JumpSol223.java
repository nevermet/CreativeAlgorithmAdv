import java.util.Scanner;

public class JumpSol223 {

	public static int n, d, m;
	public static int[] S = new int[50001];
	public static int ub = 1000000000;
	public static int lb, L;
	
	public static boolean f(int x){
		int cnt=0;
		int cur=S[0];
		for (int i = 1; i < n+2; i++){
			if (S[i]<cur+x)
				cnt++;
			else
				cur=S[i];
		}
		return (cnt<=m && cur==d);
	}
	
	public static void swap(int a, int b){
		int t = S[a];
		S[a]=S[b];
		S[b]=t;
		return;
	}
	
	public static void quick_sort(int s, int e){
		if (s<e){
			int p=s, l=s+1, r=e;
			while(l<=r){
				while(l<=e && S[l]<=S[p])
					l++;
				while(r>=s+1 && S[r]>=S[p])
					r--;
				if (l<r)
					swap(l,r);
			}
			swap(p,r);
			quick_sort(s, r-1);
			quick_sort(r+1,e);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < n; i++)
			S[i]=sc.nextInt();
		
		sc.close();
		S[n]=0;
		S[n+1]=d;
		
		quick_sort(0, n+1);
		while(lb<ub){
			L=(lb+ub+1)/2;
			if(f(L))
				lb=L;
			else
				ub=L-1;
		}
		System.out.println(ub);
		return;
	}

}
