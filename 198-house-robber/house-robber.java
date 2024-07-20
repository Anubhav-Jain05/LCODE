class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return maxProfit(nums,0,map);
    }
    private int maxProfit(int[] nums,int currentIndex,HashMap<Integer,Integer> map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int rob=nums[currentIndex] + maxProfit(nums,currentIndex + 2,map);
        int no_rob=maxProfit(nums,currentIndex + 1,map);
        map.put(currentKey,Math.max(rob,no_rob));
        return map.get(currentKey);

    }
}