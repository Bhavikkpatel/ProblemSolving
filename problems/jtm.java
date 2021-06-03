import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;
import static java.util.stream.Collectors.toList;

class Result {
  public static int journeyToMoon(int n, List<List<Integer>> in) {
      List<Integer> ast = new ArrayList<>();
      for(int i=0;i<n;i++) {
        ast.add(i);
      }
      int pairs = 0;
      if(in.size() > 1) {
        for(int i=0;i<in.size();i++) {
          for(int j=0;j<in.size();j++) {
            if(i!=j) {
              if(in.get(i).contains(in.get(j).get(0))) {
                in.get(i).add(in.get(j).get(1));
                in.remove(j);
                for(int k=0;k<in.get(i).size();k++) {
                  ast.remove(in.get(i).get(k));
                }
                j = -1;
              } else if(in.get(i).contains(in.get(j).get(1))) {
                in.get(i).add(in.get(j).get(0));
                in.remove(j);
                for(int k=0;k<in.get(i).size();k++) {
                  ast.remove(in.get(i).get(k));
                }
                j = -1;
              } else {
                for(int k=0;k<in.get(j).size();k++) {
                  ast.remove(in.get(j).get(k));
                }
              }
            }
          }
        }
      } else {
        for(int k=0;k<in.get(0).size();k++) {
          ast.remove(in.get(0).get(k));
        }
      }
      List<Integer> a;
      for(int i=0;i<ast.size();i++) {
        a = new ArrayList<>();
        a.add(ast.get(i));
        in.add(a);
      }
      // System.out.println(in);
      for(int i=0;i<in.size();i++) {
        for(int j=i+1;j<in.size();j++) {
          pairs += (in.get(i).size() * in.get(j).size());
        }
      }
      return pairs;
  }
}

public class jtm {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/bhavikkpatel/Desktop/leetcode/sample.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int p = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> astronaut = new ArrayList<>();

    IntStream.range(0, p).forEach(i -> {
        try {
            astronaut.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    });
    int result = Result.journeyToMoon(n, astronaut);
    System.out.println(result);
  }
}
