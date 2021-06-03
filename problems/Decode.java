import java.util.*;


public class Decode {
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String input = s.nextLine();
    System.out.println(numDecodings(input));
  }

  static void printArr(int[] arr) {
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
  static int numDecodings(String s) {
    int n = s.length();
    if(s.charAt(0)=='0') return 0;
    if(n==1) return 1;
    int[] dp = new int[n+5];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<=n;i++)
    {
      // printArr(dp);
      int num = s.charAt(i-1)-'0';
      int m = ((s.charAt(i-2)-'0')*10)+num;
      // System.out.println("num: "+num);
      // System.out.println("m: "+m);
      // System.out.println();
      if(num>0) {
        // System.out.println("num:\n"+"i:"+i+"\t"+dp[i]+"\n"+"i-1:"+(i-1)+"\t"+dp[i-1]);
        dp[i]+=dp[i-1];
      }
      // printArr(dp);
      if(m>9 && m<27) {
        // System.out.println("m:\n"+"i:"+i+"\t"+dp[i]+"\n"+"i-2:"+(i-2)+"\t"+dp[i-2]);
        dp[i]+=dp[i-2];
      }
      // printArr(dp);
      // System.out.println();
    }
    return dp[n];
  } 
}
