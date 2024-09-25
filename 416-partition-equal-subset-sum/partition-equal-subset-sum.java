class Solution {
    public boolean canPartition(int[] nums) {
        HashMap<String,Boolean> map = new HashMap<>();
        int total_sum =0;
        for(int num : nums){
            total_sum += num;
        }
        if(total_sum % 2 != 0 )return false;
        return isPossible(nums,0,total_sum / 2,map);
    }
    private boolean isPossible(int[] nums,int currentIndex,int targetSum,HashMap<String,Boolean> map){
        if(targetSum == 0)return true;
        if(currentIndex >= nums.length)return false;

        String currentKey= Integer.toString(currentIndex) + "-" + Integer.toString(targetSum);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        boolean consider = false;
        if(nums[currentIndex] <= targetSum){
            consider = isPossible(nums,currentIndex + 1,targetSum - nums[currentIndex],map);
        }
        if(consider){
            map.put(currentKey,true);
            return true;
        }
        boolean not_consider= isPossible(nums,currentIndex + 1,targetSum,map);
        map.put(currentKey,consider || not_consider);
        return map.get(currentKey);
    }
}