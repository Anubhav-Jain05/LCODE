class Solution {
    public int minPathSum(int[][] grid) {
        return minSum(0,0,grid.length,grid[0].length,grid,new HashMap<String,Integer>());
    }
    private int minSum(int row,int col,int m,int n,int[][] grid,HashMap<String,Integer>map){
        if(row == m-1 && col == n-1)return grid[row][col];
        if(row >= m || col >= n)return 10001;
        String currentKey=Integer.toString(row) + "-" + Integer.toString(col);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int row_col_value=grid[row][col];
        int ans=Integer.MAX_VALUE;
        int rightways=row_col_value + minSum(row,col + 1,m,n,grid,map);
        int downways=row_col_value  + minSum(row +1,col,m,n,grid,map);
        ans=Math.min(rightways,downways);
        map.put(currentKey,ans);
        return ans;
    }
}