import java.util.*;

public class triangle {

  public static void main(String[] args) {
    List<List<Integer>> t = new ArrayList<>();
    
    // [[2],[3,4],[6,5,7],[4,1,8,3]];
    t.add(new ArrayList<Integer>());
    t.get(0).add(2);
    t.add(new ArrayList<Integer>());
    t.get(1).add(3);
    t.get(1).add(4);
    t.add(new ArrayList<Integer>());
    t.get(2).add(6);
    t.get(2).add(5);
    t.get(2).add(7);
    t.add(new ArrayList<Integer>());
    t.get(3).add(4);
    t.get(3).add(1);
    t.get(3).add(8);
    t.get(3).add(3);
    System.out.println(minimumTotal(t));
  }

  static int minimumTotal(List<List<Integer>>T) {
    for (int i = T.size() - 2; i >= 0; i--) {
      for (int j = T.get(i).size() - 1; j >= 0; j--) {
        System.out.println(T.get(i+1).get(j)+", "+T.get(i+1).get(j+1));
        int min = Math.min(T.get(i+1).get(j), T.get(i+1).get(j+1));
        T.get(i).set(j, T.get(i).get(j) + min);
      }
      System.out.println(T);
    }
    
    return T.get(0).get(0);
  }
}
