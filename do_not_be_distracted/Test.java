import java.util.*;

public class Test {
	static String logic(String t) {
		int c1 = 0, c2 = 0;
		ArrayList<Character> dist = new ArrayList<>();
		char previous;
		for(int i=0;i<t.length();i++) {
			if(!dist.contains(t.charAt(i))) {
				dist.add(t.charAt(i));
			}  else if(dist.contains(t.charAt(i)) && t.charAt(i) == t.charAt(i-1)) {
				c2 = c1;
				c1++;
			} else if(dist.contains(t.charAt(i)) && t.charAt(i) != t.charAt(i-1)) {
				return "No";
			}	
		}
		return "Yes";
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			int size = s.nextInt();
			String input = s.next();
			System.out.println(logic(input));
		}
	}
}
