import java.util.*;
import java.io.*;
public class Test {
	static boolean issorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	static int permute(int[] arr, int count, int n) {
		if(issorted(arr)) {
			return count;
		} else {
			if(arr[0] == 1 && arr[n-1] == n) {
				count = 1;
			} else if(arr[0] == n && arr[n-1] == 1) {
				count = 3;
			} else if((arr[0] == 1 && arr[n-1] != n) || (arr[0] != 1 && arr[n-1] == n)) {
				count = 1;
			} else {
				count = 2;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		while(t > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(permute(arr, 0, n));
			t--;
		}
	}
}
