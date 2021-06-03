import java.util.*;

class Inversion {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        while(t-->0) {
            int size = s.nextInt();
            int[][] arr = new int[size][size];
            for(int i=0;i<size;i++) {
                for(int j=0;j<size;j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            int count = 0, p = 0, q = 0;
            for(int i=0;i<size;i++) {
                p = i;
                for(int j=1;j<size;j++) {
                    for(int k=0;k<size;k++) {
                        if(arr[i][p] > arr[j][k] && i <= j && j<=k) {
                            System.out.println(arr[i][j]+", "+arr[j][k]);
                            count++;
                        }   
                    }
                }
            }
            System.out.println(count);
        }
    }
}



