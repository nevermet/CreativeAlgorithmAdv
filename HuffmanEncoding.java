import java.util.Scanner;

public class HuffmanEncoding {

	public static int k;
	public static char[] longcode = new char[251];
	public static char[] hufftree = new char[1<<20];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		
		char c;
		char[] code = new char[21];
		
		for (int i = 0; i <k; i++){
			c = sc.next().charAt(0);
			
			code = sc.next().toCharArray();
			
			int l =0;
			int p =1;
			while(l<code.length){
				if (code[l++]=='0')
					p*=2;
				else
					p=(p*2)+1;
			}
			hufftree[p]=c;
		}
		
		longcode = sc.next().toCharArray();
		
		sc.close();
		
		int lp=0;
		int tp =1;
		while(lp<longcode.length){
			if (longcode[lp++]=='0')
				tp*=2;
			else
				tp = (tp*2)+1;
			
			if (hufftree[tp]!='\0'){
				System.out.print(hufftree[tp]);
				tp=1;
			}	
		}
		return;
	}

}
