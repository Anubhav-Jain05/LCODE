class Solution {
    public int search(int[] nums, int target) {
        return targetIndex(nums,0,nums.length-1,target);
    }
    private int targetIndex(int[] nums,int start,int end,int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] > target)return targetIndex(nums,start,mid-1,target);
            else return targetIndex(nums,mid+1,end,target);
        }
        return -1;
    }
}