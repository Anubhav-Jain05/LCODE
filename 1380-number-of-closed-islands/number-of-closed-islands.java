class Solution {
    public int closedIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int currentCol=0;currentCol < m;currentCol++){
            if(grid[0][currentCol] == 0){
                land(grid,0,currentCol,n,m);
            }
            if(grid[n-1][currentCol] == 0){
                land(grid,n-1,currentCol,n,m);
            }
        }
        for(int currentRow=0;currentRow < n;currentRow++){
            if(grid[currentRow][0] == 0){
                land(grid,currentRow,0,n,m);
            }
            if(grid[currentRow][m-1] == 0){
                land(grid,currentRow,m-1,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    land(grid,i,j,n,m);
                    ans+=1;
                }
            }
        }
        return ans;
    }
    private void land(int[][] grid,int row,int col,int n,int m){
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 1)return;
        grid[row][col]=1;
        land(grid,row-1,col,n,m);
        land(grid,row+1,col,n,m);
        land(grid,row,col-1,n,m);
        land(grid,row,col+1,n,m);
        return;
    }
}