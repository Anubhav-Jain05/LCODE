class Solution {
    public int searchInsert(int[] nums, int target) {
        int index =-1;
        int start =0;
        int end = nums.length-1;
        while(start <= end){
            int mid=start + (end-start) /2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] < target){
                start = mid + 1;
            }else{
                index=mid;
                end=mid-1;
            }
        }
        if(index == -1)return nums.length;
        return index;
    }
}