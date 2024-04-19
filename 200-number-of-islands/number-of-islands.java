class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null)return 0;
        int row=grid.length;
        int col=grid[0].length;
        int count =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int row,int col){
        int numrow=grid.length;
        int numcol=grid[0].length;

        if(row < 0 || col < 0 || row >= numrow || col >= numcol || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';

        dfs(grid,row + 1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col + 1);
        dfs(grid,row,col-1);
    }
}