class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashMap<String,Integer>map=new HashMap<>();
        int area= 0;
        for(int currentrow =0 ;currentrow < m;currentrow++){
            for(int currentcol =0 ;currentcol<n;currentcol ++){
                if(matrix[currentrow][currentcol] == '1'){
                    int sidelen=maxSize(matrix,currentrow,currentcol,m,n,map);
                    area=Math.max(area,sidelen * sidelen);
                }
            }
        }
        return area;
    }
    private int maxSize(char[][] matrix,int currentrow,int currentcol,int m,int n,HashMap<String,Integer>map){
        if(currentrow <0 || currentrow >= m ||
            currentcol < 0 ||currentcol >= n || 
            matrix[currentrow][currentcol] == '0'){
                return 0;
        }
        // if(currentrow == m-1 && currentcol ==n-1){
        //     return matrix[currentrow][currentcol];
        // }
        String currentKey=currentrow + "-" + currentcol;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int right=1 + maxSize(matrix,currentrow,currentcol + 1,m,n,map);
        int down=1 + maxSize(matrix,currentrow + 1,currentcol,m,n,map);
        int rightdiagonal=1 + maxSize(matrix,currentrow + 1,currentcol + 1,m,n,map);
        
        map.put(currentKey,Math.min(right,Math.min(down,rightdiagonal)));
        return map.get(currentKey);
    }
}