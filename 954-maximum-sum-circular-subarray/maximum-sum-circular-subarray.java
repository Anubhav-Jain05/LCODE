class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int currmin=0;
        int min=Integer.MAX_VALUE;
        int currmax=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            currmax=Math.max(currmax + num,num);
            max=Math.max(currmax,max);
            currmin=Math.min(currmin + num,num);
            min=Math.min(currmin,min);
            sum += num;
            
        }
        if(max < 0)return max;
        return Math.max(max,sum-min);
    }
}