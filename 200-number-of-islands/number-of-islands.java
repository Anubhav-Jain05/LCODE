class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;

        for(int currentrow=0;currentrow < m;currentrow++){
            for(int currentCol=0;currentCol<n;currentCol++){
                if(grid[currentrow][currentCol] == '1'){
                    sinkIsland(grid,currentrow,currentCol,m,n);
                    ans += 1;
                }
            }
        }
        return ans;
    }
    private void sinkIsland(char[][] grid,int currentrow,int currentCol,int m,int n){
        if(currentrow < 0 || currentrow >= m || 
            currentCol < 0 || currentCol >= n || 
            grid[currentrow][currentCol] == '0')return;

        grid[currentrow][currentCol] = '0';
        sinkIsland(grid,currentrow - 1 ,currentCol,m,n);
        sinkIsland(grid,currentrow + 1,currentCol,m,n);
        sinkIsland(grid,currentrow ,currentCol - 1,m,n);
        sinkIsland(grid,currentrow ,currentCol + 1,m,n);
        return;

    }
}