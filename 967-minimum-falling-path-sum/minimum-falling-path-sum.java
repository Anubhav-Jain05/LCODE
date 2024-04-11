class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashMap<String,Integer>map= new HashMap<>();
        int ans=1000000;
        for(int currentCol =0;currentCol < n;currentCol ++){
            int tempAns=minPathSum(matrix,0,currentCol,m,n,map);
            ans=Math.min(tempAns,ans);
        }
        return ans;
    }
    private int minPathSum(int[][] matrix,int currentrow,int currentCol,int m,int n,HashMap<String,Integer>map){
        if(currentCol < 0 || currentCol >=n)return 10001;
        if(currentrow == m-1){
            return matrix[currentrow][currentCol];
        }
        String currentKey=currentrow + "-" + currentCol;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int leftDiagonal=matrix[currentrow][currentCol] + 
            minPathSum(matrix,currentrow +1,currentCol-1,m,n,map);
        int down=matrix[currentrow][currentCol] + 
            minPathSum(matrix,currentrow +1,currentCol,m,n,map);
        int rightdiagonal=matrix[currentrow][currentCol] + 
            minPathSum(matrix,currentrow + 1,currentCol +1,m,n,map);
        map.put(currentKey,Math.min(rightdiagonal,Math.min(leftDiagonal,down)));
        return map.get(currentKey);
    }
}