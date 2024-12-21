class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return (Math.min(minJump(cost,0,map),minJump(cost,1,map)));
    }
    private int minJump(int[] cost,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex == cost.length)return 0;
        if(currentIndex > cost.length)return 1001;

        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int onejump=cost[currentIndex] + minJump(cost,currentIndex + 1,map);
        int twojump=cost[currentIndex] + minJump(cost,currentIndex + 2,map);
        map.put(currentKey,Math.min(onejump,twojump));
        return map.get(currentKey);
    }
}