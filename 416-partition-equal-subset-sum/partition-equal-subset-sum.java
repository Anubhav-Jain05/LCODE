class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum += num;
        }
        if(totalSum % 2 != 0)return false;
        return isPossible(nums,0,totalSum / 2,new HashMap<String,Boolean>());
    }
    private boolean isPossible(int[] nums,int currentIndex,int targetSum,HashMap<String,Boolean>map){
        if(targetSum == 0)return true;
        if(currentIndex >= nums.length)return false;
        String currentKey=Integer.toString(currentIndex) +"_"+Integer.toString(targetSum);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        boolean consider=false;
        if(nums[currentIndex] <= targetSum){
             consider=isPossible(nums,currentIndex+1,targetSum-nums[currentIndex],map);
        }
        if(consider){
            map.put(currentKey,true);
            return true;
        }
        boolean notConsider=isPossible(nums,currentIndex + 1,targetSum,map);
        map.put(currentKey,consider || notConsider);
        return map.get(currentKey);

    }
}