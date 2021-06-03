import java.util.*;
class node {
	int cityN;
	int childc;
	ArrayList<Integer> children;
	boolean visited;
	node() {
		this.childc = 0;
	}
}
class Test {
	static ArrayList<node> city;
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			int nc = s.nextInt();	
			city = new ArrayList<>();
			for(int i=0;i<nc;i++) {
				node ncity = new node();
				city.add(ncity);
			}
			for(int i=0;i<(nc-1);i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				city.get(x-1).children.add(y-1);
				city.get(x-1).childc = city.get(x-1).children.size();
			}
			System.out.println(city);
			int[] cost = new int[nc];
			for(int i=0;i<nc;i++) {
				cost[i] = s.nextInt();
			}
			int q = s.nextInt();
			for(int i=0;i<q;i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				
			}
		}
	}
}
