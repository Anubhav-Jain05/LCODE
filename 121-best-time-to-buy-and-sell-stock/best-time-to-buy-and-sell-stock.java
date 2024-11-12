class Solution {
    public int maxProfit(int[] prices) {
       int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;

       for(int num:prices){
        min=Math.min(min,num);
        max=Math.max(max,num-min);
       }
       return max;
    }
}