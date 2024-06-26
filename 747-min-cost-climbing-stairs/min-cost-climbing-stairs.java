class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer>map = new HashMap<>();
        return Math.min(minimumCost(cost,0,map),minimumCost(cost,1,map));
    }
    private int minimumCost(int[] cost,int currentIndex,HashMap<Integer,Integer> map){
        if(currentIndex == cost.length)return 0;
        if(currentIndex > cost.length) return 1001;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int one_jump=cost[currentIndex] + minimumCost(cost,currentIndex + 1,map);
        int two_jump=cost[currentIndex] + minimumCost(cost,currentIndex + 2,map);

        map.put(currentKey,Math.min(one_jump,two_jump));
        return map.get(currentKey);

    }
}