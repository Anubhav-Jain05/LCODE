class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return possibleWays(obstacleGrid,obstacleGrid.length,obstacleGrid[0].length,0,0,new HashMap<String,Integer>());
    }
     private int possibleWays(int[][] grid,int m,int n,int row,int col,HashMap<String,Integer> map){
         if(row >= m || col >= n || grid[row][col] == 1)return 0;
        if(row == m-1 && col == n-1 && grid[row][col] != -1)return 1;
       
        String currentKey=Integer.toString(row)+"-"+Integer.toString(col);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int right=possibleWays(grid,m,n,row,col+1,map);
        int down=possibleWays(grid,m,n,row+1,col,map);
        map.put(currentKey,(right + down));
        return map.get(currentKey);
    }
}