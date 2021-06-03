import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class queensAtt {
	static int queensAttack(int n, int k, int r, int c, List<List<Integer>> ob) {
        int up = r - 1;
        int down = n - r;
        int left = c - 1;
        int right = n - c;
          
        
        for(int i=0;i<ob.size();i++) {
        	if(ob.get(i).get(1) == c && ob.get(i).get(0) < r) {
        		up = Math.min(up, r - ob.get(i).get(0) - 1);
        	}
        	if(ob.get(i).get(1) == c && ob.get(i).get(0) > r) {
        		down = Math.min(down, n - ob.get(i).get(0) - 1);
        	}
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/bhavikkpatel/Desktop/leetcode/queensinput.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.print(result);
      
    }
}
