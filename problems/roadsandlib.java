import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Solution {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int count;
    public static long roadsAndLibraries(int n, int x, int y, List<List<Integer>> cities, int m) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println("x: "+x+", y: "+y);
        for(int i=0;i<m;i++) {
            adj.get(cities.get(i).get(0)-1).add(cities.get(i).get(1)-1);
            adj.get(cities.get(i).get(1)-1).add(cities.get(i).get(0)-1);
        }
        // System.out.println(adj);
        long cost = 0;
        for (int i = 0; i < adj.size(); i++) {
            // System.out.println(visited[i]);
            if (!visited[i]) {
                count = 0;
                dfs(i);
                System.out.println("at i = "+i+", count = "+count);
                if (x > y) {
                    cost += x + y * (count - 1); 
                } else {
                    cost += x * count;
                }
                System.out.println("cost: "+cost);
            }
        }
        return cost; 
    }
    static void dfs(int i) {
        visited[i] = true;
        count++;
        List<Integer> list = adj.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (!visited[list.get(j)]) {
                dfs(list.get(j));
            }
        }
    }
}

class roadsandlib {
  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/bhavikkpatel/Desktop/leetcode/test.txt"));
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      IntStream.range(0, q).forEach(qItr -> {
          try {
              String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

              int n = Integer.parseInt(firstMultipleInput[0]);

              int m = Integer.parseInt(firstMultipleInput[1]);

              int c_lib = Integer.parseInt(firstMultipleInput[2]);

              int c_road = Integer.parseInt(firstMultipleInput[3]);

              List<List<Integer>> cities = new ArrayList<>();

              IntStream.range(0, m).forEach(i -> {
                  try {
                      cities.add(
                          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                              .map(Integer::parseInt)
                              .collect(toList())
                      );
                  } catch (IOException ex) {
                      throw new RuntimeException(ex);
                  }
              });
            //   System.out.println(cities.size());
              Solution.visited = new boolean[n];
              long result = Solution.roadsAndLibraries(n, c_lib, c_road, cities, m);
              System.out.println(result);
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
      });
      bufferedReader.close();
  }
}