import java.util.Scanner;

public class NodeDistance {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int first = 0;
		int second = 0;
		int fd =0;
		int sd = 0;
		
		first = sc.nextInt();
		second = sc.nextInt();
		
		sc.close();
		while(first != second) {
			if (first > second) {
				first /=2;
				fd++;
			}
			else {
				second /=2;
				sd++;
			}
		}
		
		System.out.println(fd+sd);
		
		return;
	}
}
