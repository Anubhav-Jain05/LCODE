class Solution {
    public int uniquePaths(int m, int n) {
        return maxPath(m,n,0,0,new HashMap<String,Integer>());
    }
    private int maxPath(int m,int n,int row,int col,HashMap<String,Integer>map){
        if(row == m-1 && col == n-1)return 1;
        if(row >= m || col >= n )return 0;
        String currentKey=Integer.toString(row)+"-"+Integer.toString(col);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int rightways=maxPath(m,n,row,col + 1,map);
        int downways=maxPath(m,n,row + 1,col,map);

        map.put(currentKey,(rightways + downways));
        return map.get(currentKey);
    }
}