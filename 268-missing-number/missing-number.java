class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        // int totSum=n * (n + 1) /2;
        int totSum=0;
        for(int i=0;i<=n;i++){
            totSum += i;
        }
        int arrSum=0;
        for(int num:nums){
            arrSum += num;
        }
        return totSum -arrSum;
    }
}