class Solution {
    public int climbStairs(int n) {
        return totalways(n,0,new HashMap<>());
    }
    private int totalways(int n,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex == n)return 1;
        if(currentIndex >= n)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int one=totalways(n,currentIndex +1,map);
        int two=totalways(n,currentIndex +2,map);
        map.put(currentKey,one+two);
        return map.get(currentKey);
    }
}