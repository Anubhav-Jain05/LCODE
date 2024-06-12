class Solution {
    public void sortColors(int[] nums) {
        int count=0;
        int count1=0;
        int count2=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }else if(nums[i]==1){
                count1++;
            }else{
                count2++;
            }
        }
        for(int i=0;i<count;i++){
            nums[i]=0;
        }
        for(int i=count;i<count + count1;i++){
            nums[i]=1;
        }
        for(int i=count + count1;i<nums.length;i++){
            nums[i]=2;
        }
    }
}