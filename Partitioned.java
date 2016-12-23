import java.util.Scanner;

public class Partitioned {

	public static int n;
	public static int[] arr = new int[30];
	
	public static void f(int k, int id){
		
		if (k==0){
			for (int i = 0; i <id; i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
			return;
		}
					
		for (int i = k; i >= 1; i--) {
			
			if (id == 0)
				arr[id] = i;
			else if (arr[id-1] >= i)
				arr[id]= i;
			else
				continue;
			f(k-i, id+1);
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		f(n, 0);
		
		sc.close();
		
		return;
		
	}

}
