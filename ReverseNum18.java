import java.util.Scanner;

public class ReverseNum18 {

	public static int n;
	
	
	public static void f(int i) {
		// 숫자가 0보다 크면
		if (i > 0) {
			// 제일 마지막 자리를 출력한다.
			System.out.print(i%10);
			// 그리고 제일 마지막 자리를 없애고 재귀 호출 한다.
			f(i/10);
		}
		return;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Scanner 클래스로 input처리
		Scanner sc = new Scanner(System.in);
		
		// 하나의 숫자 n 읽기 
		n = sc.nextInt();
		// 자바에서는 읽는 것이 끝났다면, 바로 자원 해제하여 메모리 관리
		// 이 코드가 없으면 경고 표시 나타남 
		sc.close();

		// 숫자 뒷부분이 0으로 끝나는 경우 미리 0을 제외 
		while (n % 10 == 0) {
			n = n/10;
		}
		
		f(n);
		
		return;
	}

}
