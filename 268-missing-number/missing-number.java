class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int indexSum=0;
        for(int i=0;i<=nums.length;i++){
            indexSum += i;
        }
        int arrSum=0;
        for(int num:nums){
            arrSum += num;
        }
        return indexSum - arrSum;
    }
}