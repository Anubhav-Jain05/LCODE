class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)return 0;

        int max =0;
        for(int num:nums){
            max = Math.max(num,max);
        }

        int[] sum = new int [max + 1];
        for(int num : nums){
            sum[num] += num;
        }
        return maxPoint(sum);
    }
    private int maxPoint(int[] sum){
        int n = sum.length;
        if(n == 1)return sum[0];

        int prev1= 0;
        int prev2=0;

        for(int i=0;i<n ;i++){
            int current=Math.max(prev1+sum[i],prev2);
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}