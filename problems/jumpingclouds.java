import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class jumpingclouds {
	static int jumpingOnClouds(List<Integer> c) {
        int ans = 0;
        for(int i=1;i<c.size()-1;) {
        	System.out.println(i+", "+c.get(i));
        	if(c.get(i) == 1) {
        		i++;
        		continue;
        	} else {
        		if((i+2) < c.size()) {
        			if(c.get(i+2) == 0) {
        				i+=2;
		    		} else {
		    			i++;
		    		}
		    		ans++;
        		} else {
        			i++;
        		}
        	}
        }
        return ++ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/bhavikkpatel/Desktop/leetcode/jumpinput.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cTemp[i]);
            c.add(cItem);
        }

        int result = jumpingOnClouds(c);
		System.out.println(result);
    }
}
