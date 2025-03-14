class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int high = nums.length -1;
        while(start <= high){
            int mid =start + (high - start ) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high=mid-1;
            }else start = mid + 1;
        }
        return -1;
    }
}