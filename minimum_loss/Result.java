import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {
        long t = 9999999, check;
        for(int i=0;i<price.size();i++) {
            for(int j=i;j<price.size();j++) {
                check = price.get(i) - price.get(j);
                if(check > 0) {
                    t = Math.min(t, check);
                } 
            }
        }
        Long a = new Long(t);
        return a.intValue();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] priceTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceTemp[i]);
            price.add(priceItem);
        }

        int result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
