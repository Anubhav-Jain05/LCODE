class Solution {
    public int lengthOfLIS(int[] nums) {
        int answer=1;
        int n= nums.length;
        int[]dp= new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                    answer=Math.max(dp[i],answer);
                }
            }
        }
        return answer;
    }
}