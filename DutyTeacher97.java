import java.util.Scanner;

public class DutyTeacher97 {

	public static int a, b;
	public static int[] p= new int[3];
	public static int[] dt = new int[1001];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		for (int i = 0; i < 3; i++)
			p[i]=sc.nextInt();
		
		sc.close();
		
		for (int i = 0; i <=1000; i++)
			dt[i]=-1;
		
		dt[a]=0;
		
		for (int i=0; i<3; i++){
			int cur=a;
			while (cur <=b){
				if (dt[cur+p[i]]==-1 || dt[cur+p[i]]>dt[cur]+1 ){
					dt[cur+p[i]]=dt[cur]+1;
				}
				cur+=p[i];				
			}			
		}
		
		System.out.println(dt[b]);
		
		return;
	}
}
