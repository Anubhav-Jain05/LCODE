class Solution {
    public int climbStairs(int n) {
        return totalWays(n,0,new HashMap<Integer,Integer>());
    }
    private int totalWays(int n,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex == n)return 1;
        if(currentIndex >= n)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int oneJump=totalWays(n,currentIndex + 1,map);
        int twoJump=totalWays(n,currentIndex + 2,map);
        map.put(currentKey,oneJump + twoJump);
        return map.get(currentKey);
    }
}