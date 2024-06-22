class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count =0;
        int oddcount=0;
        int[] prefix=new int[nums.length + 1];
        prefix[0]=1;

        for(int num:nums){
            if(num % 2== 1){
                oddcount++;
            }
            if(oddcount >= k){
                count += prefix[oddcount - k];
            }
            prefix[oddcount]++;
        }
        return count;

    }
}