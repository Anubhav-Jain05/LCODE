class Solution {
    public int subsetXORSum(int[] nums) {
        return xorSub(nums,0,0);
    }
    private int xorSub(int[] nums,int index,int CurrentXor){
        if(index == nums.length){
            return CurrentXor;
        }
        int include=xorSub(nums,index + 1, CurrentXor ^ nums[index]);
        int exclude=xorSub(nums,index + 1,CurrentXor);
        return include + exclude;
    }
}