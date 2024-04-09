class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return maxPath(0,0,obstacleGrid.length,obstacleGrid[0].length,
        obstacleGrid,new HashMap<String,Integer>());
    }
    private int maxPath(int row,int col,int m,int n,int[][] grid,HashMap<String,Integer>map){
       if(row >= m || col >= n || grid[row][col] == 1)return 0;
       if(row == m-1 && col==n-1)return 1;

        String currentKey=Integer.toString(row) + "-"+Integer.toString(col);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
       int rightways=maxPath(row,col+1,m,n,grid,map);
       int downways=maxPath(row + 1,col,m,n,grid,map);

        map.put(currentKey,(rightways + downways));
       return map.get(currentKey);
    }
}