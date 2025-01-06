class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int max=Integer.MIN_VALUE;
        int currMax=0;
        int min=Integer.MAX_VALUE;
        int currMin=0;
        for(int num : nums){
            currMax=Math.max(currMax + num,num);
            max=Math.max(max,currMax);
            currMin=Math.min(currMin + num,num);
            min=Math.min(min,currMin);
            totalSum += num;
            
        }
        if(max < 0){
            return max;
        }
        return Math.max(max,totalSum - min);
    }
}