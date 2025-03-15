class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minimumcost(cost,0,new HashMap<>()),minimumcost(cost,1,new HashMap<>()));
    }
    private int minimumcost(int[] cost,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex == cost.length)return 0;
        if(currentIndex > cost.length)return 1001;

        int currentkey=currentIndex;
        if(map.containsKey(currentkey)){
            return map.get(currentkey);
        }
        int one=cost[currentIndex] + minimumcost(cost,currentIndex +1,map);
        int two=cost[currentIndex] + minimumcost(cost,currentIndex + 2,map);

        map.put(currentkey,Math.min(one,two));
        return map.get(currentkey);
    }
}