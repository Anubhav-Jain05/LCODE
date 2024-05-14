class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] != 0){
                    maxGold=Math.max(maxGold,backtrack(grid,i,j));
                }
            }
        }
        return maxGold;
    }
    private int backtrack(int[][] grid,int row,int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        int temp=grid[row][col];
        grid[row][col]=0; // mark as visited

        int up=backtrack(grid,row-1,col);
        int down=backtrack(grid,row+1,col);
        int left=backtrack(grid,row,col -1);
        int right=backtrack(grid,row,col + 1);

        grid[row][col]=temp;

        return temp + Math.max(Math.max(up,down),Math.max(left,right));
    }
}