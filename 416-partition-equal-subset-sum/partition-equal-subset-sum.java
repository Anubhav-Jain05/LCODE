class Solution {
    public boolean canPartition(int[] nums) {
        HashMap<String,Boolean>map= new HashMap<>();
        int target=0;
        for(int num:nums){
            target += num;
        }
        if(target % 2 != 0)return false;
        return isPartition(nums,0,target / 2,map);
    }
    private boolean isPartition(int[] nums,int currentIndex,int target,HashMap<String,Boolean>map){
        if(target == 0)return true;
        if(currentIndex >= nums.length)return false;

        String currentKey=Integer.toString(currentIndex) +"-"+Integer.toString(target);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        boolean consider=false;
        if(nums[currentIndex] <= target){
            consider= isPartition(nums,currentIndex + 1,target-nums[currentIndex],map);
        }
        if(consider){
            map.put(currentKey,true);
            return true;
        }
        boolean notConsider=isPartition(nums,currentIndex + 1,target,map);
        map.put(currentKey,consider || notConsider);
        return map.get(currentKey);
    }
}