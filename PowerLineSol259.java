import java.util.Scanner;

public class PowerLineSol259 {

	static class W{
		public int a = 0;
		public int b = 0;
	}
	
	public static W[] d = new W[100001];
	public static W[] h = new W[100001];
	public static int[] IDT = new int[1<<22];
	
	public static void update(int n){
		while(n>1){
			if(IDT[n]>IDT[n/2])
				IDT[n/2]=IDT[n];
			n>>=1;
		}			
	}
	
	public static int max(int a, int b){
		return a > b ? a : b;
	}
	
	public static int lg_sum(int s, int e){
		int m = 0;
		while(s < e){
			m=max(m, IDT[e]);
			if((e%2)==0)
				e--;
			e>>=1;
			s>>=1;
		}
		if (s==e)
			m=max(m, IDT[s]);
		return m;
	}
		
	public static void mergesort(int low, int high){
		
		if (low < high){
			int middle = low +(high-low)/2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
		return;
	}
	
	public static void merge(int low, int middle, int high){
		
		for (int i = low; i <= high; i++)
			h[i]=d[i];
		
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i<=middle && j <= high){
			if (h[i].a<=h[j].a){
				d[k]=h[i];
				i++;
			}
			else{
				d[k]=h[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle){
			d[k]=h[i];
			k++;
			i++;
		}
		return;
	}
	
	public static void main(String[] args) {
		int i, base, n, m=-1;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (i = 1; i<=n; i++){
			d[i]= new W();
			d[i].a = sc.nextInt();
			d[i].b = sc.nextInt();
			if (m < d[i].b)
				m = d[i].b;
		}
		sc.close();
		
		mergesort(1,8);
		
		for (base =1; base<m; base<<=1);
		for (i=1; i<=n; i++){
			IDT[base+d[i].b-1]=lg_sum(base,base+d[i].b-2)+1;
			update(base+d[i].b-1);
		}
		System.out.println(n-IDT[1]);
		return;
	}

}
