class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int indexSum=0;
        for(int i=0;i<=n;i++){
            indexSum += i;
        }
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        return indexSum-sum;
    }
}