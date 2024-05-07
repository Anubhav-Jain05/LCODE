class Solution {
    public int rob(int[] nums) {
        return maximumSum(nums,0,new HashMap<Integer,Integer>());
    }
    private int maximumSum(int[] nums,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int rob=nums[currentIndex] + maximumSum(nums,currentIndex + 2,map);
        int notrob=maximumSum(nums,currentIndex + 1,map);
        map.put(currentKey,Math.max(rob,notrob));
        return map.get(currentKey);
    }
}