class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    land(grid,i,j,n,m);
                    ans+=1;
                }
            }
        }
        return ans;
    }
    private void land(char[][] grid,int row,int col,int n,int m){
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0')return  ;
        grid[row][col]='0';
        land(grid,row-1,col,n,m);
        land(grid,row+1,col,n,m);
        land(grid,row,col-1,n,m);
        land(grid,row,col+1,n,m);
        return;
    }
}