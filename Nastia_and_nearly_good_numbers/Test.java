import java.util.*;

public class Test {
	static long x = 1, y = 1, z = 1;
	static boolean logic(long a, long b) {
		if(b == 1) {
			return false;
		} else {
			x = a;
			y = a * b;
			z = x + y;
			return true;
		}
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		long a, b;
		while(t-- >0) {
			a = s.nextInt();
			b = s.nextInt();
			if(logic(a, b)) {
				System.out.print("YES\n"+x+" "+y+" "+z+"\n");
			} else {
				System.out.println("NO");
			}
		}
	}
}
