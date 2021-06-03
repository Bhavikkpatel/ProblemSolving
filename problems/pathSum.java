class pathSum {
  public static void main(String []args) {
    // int[][] grid = {{1, 2, 3},{4, 5, 6}};
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    // System.out.println(grid.length);
    System.out.println(sum(grid));
  }
  static void display(int[][] grid) {
    for(int i=0;i<grid.length;i++) {
      for(int j=0;j<grid[i].length;j++) {
        System.out.print(grid[i][j]+" ");
      }
      System.out.println();
    }
  }
  static int sum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // int index = 1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) grid[i][j] = grid[i][j];
            else if (i == 0 && j != 0) grid[i][j] = grid[i][j] + grid[i][j-1];
            else if (i != 0 && j == 0) grid[i][j] = grid[i][j] + grid[i-1][j];
            else {
                grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
            }
            // System.out.println("print #"+index++);
            // display(grid);
        }
    }
    return grid[m-1][n-1];
  }
}