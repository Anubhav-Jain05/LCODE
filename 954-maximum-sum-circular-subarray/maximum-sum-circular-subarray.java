class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int currmax=0;
        int currmin=0;
        int sum=0;
        for(int num:nums){
            currmax=Math.max(currmax+num,num);
            max=Math.max(currmax,max);
            currmin=Math.min(currmin+num,num);
            min=Math.min(min,currmin);
            sum += num;
        }
        if(max < 0)return max;
        return Math.max(max,sum-min);
    }
}