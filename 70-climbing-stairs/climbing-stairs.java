class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map= new HashMap<>();
        return totalways(n,0,map);
    }
    private int totalways(int n,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex == n)return 1;
        if(currentIndex > n)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int onejump=totalways(n,currentIndex + 1,map);
        int twojump=totalways(n,currentIndex + 2,map);
        map.put(currentKey,onejump+twojump);
        return map.get(currentKey);
    }
}