class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sumCount(nums,0,target,new HashMap<String,Integer>());
    }
    private int sumCount(int[] nums,int currentIndex,int target,HashMap<String,Integer>map){
        if(currentIndex == nums.length && target == 0)return 1;
        if(currentIndex == nums.length && target != 0)return 0;

        String currentKey=currentIndex +"-"+target;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int plus=sumCount(nums,currentIndex +1,target-nums[currentIndex],map);
        int minus=sumCount(nums,currentIndex + 1,target+nums[currentIndex],map);
        map.put(currentKey,plus+minus);
        return map.get(currentKey);
    }
}