class Solution {
    public int uniquePaths(int m, int n) {
        return possibleWays(m,n,0,0,new HashMap<String,Integer>());
    }
    private int possibleWays(int m,int n,int row,int col,HashMap<String,Integer> map){
        if(row == m-1 && col == n-1)return 1;
        if(row >= m || col >= n)return 0;
        String currentKey=Integer.toString(row)+"-"+Integer.toString(col);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int right=possibleWays(m,n,row,col+1,map);
        int down=possibleWays(m,n,row+1,col,map);
        map.put(currentKey,right + down);
        return map.get(currentKey);
    }
}