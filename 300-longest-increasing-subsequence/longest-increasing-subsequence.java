class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}