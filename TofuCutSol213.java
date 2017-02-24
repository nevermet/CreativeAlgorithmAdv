import java.util.Scanner;

public class TofuCutSol213 {

	public static int cu(){
		return 1<<n;
	}
	
	public static int rt(){
		return 1<<(n-1);
	}
	
	public static int dn(){
		return 1;
	}
	
	public static int M(){
		return 1<<(n+1);
	}
	
	public static int[][] p = new int[][]{
		{100,70, 40, 0},
		{70, 50, 30, 0},
		{40, 30, 20, 0},
		{0, 0, 0, 0, 0}
	};
	
	public static int n;
	public static int[][] tb = new int[12][12];
	public static int[][][] m = new int[12][12][1<<13];
	
	public static int max(int a, int b){
		return a > b ? a : b;
	}
	
	public static int f(int x, int y, int s){
		if (x==n)
			return 0;
		if (y==n)
			return f(x+1, 0, s);
		if (m[x][y][s]<=0){
			if ((s&cu())<=0){
				if (y+1<n && (s&rt())<=0)
					m[x][y][s]=max(m[x][y][s], 
							f(x,y+2,(s<<2)%M())+p[tb[x][y]][tb[x][y+1]]);
				if (x+1 < n && (s&dn())<=0)
					m[x][y][s]=max(m[x][y][s],
							f(x,y+1,((s|dn())<<1)%M())+p[tb[x][y]][tb[x+1][y]]);
				m[x][y][s]=max(m[x][y][s], f(x,y+1,(s<<1)%M()));
			}
			else
				m[x][y][s]=max(m[x][y][s], f(x,y+1,(s<<1)%M()));
		}
		return m[x][y][s];
	}
	
	public static void main(String[] args) {
		int i, j;
		char t;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (i=0; i<n; i++){
			String temp = sc.next();
			for (j=0; j<n; j++){
				t = temp.charAt(j);
				tb[i][j]=(t=='F'? 3: t-'A');
			}
		}
		sc.close();
		System.out.println(f(0,0,0));
		return;
	}

}
