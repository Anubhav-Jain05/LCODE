class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        // int left=0;
        // int right=n*m-1;
        // while(left <= right){
        //     int mid=(left + right) /2;
        //     int row=mid/m,col=mid % m;
        //     if(matrix[row][col]==target){
        //         return true;
        //     }else if(matrix[row][col] < target){
        //         left=mid+1;
        //     }else{
        //         right=mid-1;
        //     }
        // }
        // return false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}