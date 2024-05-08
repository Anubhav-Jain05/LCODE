class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums,0,target,new HashMap<String,Integer>());
    }
    private int totalWays(int[] nums,int currentIndex,int target,HashMap<String,Integer>map){
        if(currentIndex == nums.length && target==0)return 1;
        if(currentIndex == nums.length && target != 0)return 0;
        String currentKey=currentIndex +"-"+target;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int add_plus=totalWays(nums,currentIndex + 1,target-nums[currentIndex],map);
        int minus=totalWays(nums,currentIndex + 1,target + nums[currentIndex],map);
        map.put(currentKey,add_plus + minus);
        return map.get(currentKey);

    }
}