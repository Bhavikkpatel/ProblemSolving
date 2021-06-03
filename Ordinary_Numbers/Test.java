import java.util.*;

public class Test {
	static int logic(int n) {
		if(n<=9) {
			return n;
		}
		long m = n, x = 1;
		int count = 0;
		while(x <= m) {
			for(long i=1;i<10;i++) {
				if(i*x > m) {
					break;
				}
				count++;
			}
			x = x * 10 + 1;
		}
		return count;
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			int n = s.nextInt();
			System.out.println(logic(n));
		}
	}
}
