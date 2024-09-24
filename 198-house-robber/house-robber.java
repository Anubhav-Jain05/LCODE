class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return maximumAmt(nums,0,map);
    }
    private int maximumAmt(int[] nums,int currentIndex,HashMap<Integer,Integer> map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int rob=nums[currentIndex] + maximumAmt(nums,currentIndex + 2,map);
        int not_rob=maximumAmt(nums,currentIndex + 1,map);
        map.put(currentKey,Math.max(rob,not_rob));
        return map.get(currentKey);
    }
}