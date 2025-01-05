class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[nums.length];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i] =ans[i-1] * nums[i-1];
        }
        int mul=1;
        for(int i = n-1;i>=0;i--){
            ans[i] *=mul;
            mul *= nums[i];
        }
        return ans;
    }
}