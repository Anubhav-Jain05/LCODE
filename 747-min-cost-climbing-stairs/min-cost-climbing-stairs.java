class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return Math.min(mincost(cost,0,map),mincost(cost,1,map));
    }
    private int mincost(int[] costs,int currentIndex,HashMap<Integer,Integer> map){
        if(currentIndex == costs.length)return 0;
        if(currentIndex > costs.length) return 1001;

        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int onejump=costs[currentIndex] + mincost(costs,currentIndex + 1,map);
        int twojump=costs[currentIndex] + mincost(costs,currentIndex + 2,map);
        map.put(currentKey,Math.min(onejump,twojump));
        return map.get(currentKey);
    }
}