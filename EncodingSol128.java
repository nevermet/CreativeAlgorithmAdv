import java.util.Scanner;

public class EncodingSol128 {

	public static char str;
	public static char[] strvalue = new char[2]; // 2이면 충분 
	public static char[] data = new char[251]; // 251이면 충분 
	public static char[] tree = new char [1048577]; // 2의 20제곱은 1024 * 1024 즉, 1048576이면 충분 
	
	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		
		for (int i = 1; i <= k; i++) {
			// 문자와 값을 읽음 
			str = sc.next().charAt(0);
			strvalue = sc.next().toCharArray();
			
			int idx = 1;
			
			// 트리 위치를 찾아내 적음
			// 문제 해설에 버그 있음 idx는 트리 인덱스이며 strvalue를 위한 인덱스 별도 필요 (id)
			for (int id = 0; strvalue.length > id; id++) {
				if(strvalue[id]=='0')
					idx *= 2;
				else
					idx = idx*2+1;
			}
			tree[idx]=str;
		}
		// 암호화된 값 읽음 
		data = sc.next().toCharArray();
		
		sc.close();
		
		int idx = 1;
		
		// 트리에서 위치를 찾아내 출력 
		for (int i = 0; data.length > i; i++) {
			if (data[i]=='0')
				idx *= 2;
			else
				idx=idx*2+1;
			if (tree[idx]!= '\0') {
				System.out.print(tree[idx]);
				idx=1;
			}
		}
		return;
	}

}
