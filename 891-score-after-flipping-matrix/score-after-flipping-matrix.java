class Solution {
    public int matrixScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                togglerow(grid[i]);
            }
        }
        for(int j=1;j<m;j++){
            int countones=0;
            for(int i=0;i<n;i++){
                countones += grid[i][j];
            }
            if(countones < n - countones){
                togglecol(grid,j);
            }
        }
        int score=0;
        for(int[] row : grid){
            score += binaryconvert(row);
        }
        return score;
    }
    private void togglerow(int[] row){
        for(int i=0;i<row.length;i++){
            row[i] = 1-row[i];
        }
    }
    private void togglecol(int[][] grid,int col){
        for(int i=0;i<grid.length;i++){
            grid[i][col]=1-grid[i][col];
        }
    }
    private int binaryconvert(int[] binary){
        int decimal=0;
        for(int i= binary.length-1; i>=0;i--){
            decimal += binary[i] << (binary.length -1 -i);
        }
        return decimal;
    }

}