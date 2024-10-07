class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newcolor) {
        if(grid[sr][sc] == newcolor)return grid;

        dfs(grid,sr,sc,grid[sr][sc],newcolor);
        return grid;
    }
    private void dfs(int[][] grid,int currentRow,int currentCol,int color, int newcolor){
        if(currentRow < 0 || currentRow >= grid.length ||
            currentCol < 0 || currentCol >= grid[0].length ||
            grid[currentRow][currentCol] != color){
                return;
        }
        grid[currentRow][currentCol] = newcolor;

        dfs(grid,currentRow - 1,currentCol,color,newcolor);
        dfs(grid,currentRow + 1,currentCol,color,newcolor);
        dfs(grid,currentRow,currentCol + 1,color,newcolor);
        dfs(grid,currentRow ,currentCol - 1,color,newcolor);
        return;
    }
}