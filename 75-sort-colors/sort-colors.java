class Solution {
    public void sortColors(int[] nums) {
        // int count=0,count1=0,count2=0;

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         count++;
        //     }else if(nums[i]==1)count1++;
        //     else count2++;
        // }
        // for(int i=0;i<count;i++){
        //     nums[i]=0;
        // }
        // for(int i=count;i<count + count1;i++){
        //     nums[i]=1;
        // }
        // for(int i=count + count1;i<nums.length;i++){
        //     nums[i]=2;
        // }
        int count=0,count1=0,count2=0;
        int n=nums.length-1;
        int left=0;
        int right=nums.length-1;

        // while(left <= right){
        //     if(nums[left] == 0){
        //         count++;
        //         left++;
        //     }else if(nums[left] == 1){
        //         count1++;
        //         left++;
        //     }else if(nums[left] == 2){
        //         count2 ++;
        //         left++;
        //     }
        // }
        for(int num:nums){
            if(num ==0)count++;
            else if(num == 1)count1++;
            else count2++;
        }
        for(int i=0;i<count;i++){
            nums[i]=0;
        }
        for(int i=count;i<count+count1;i++){
            nums[i]=1;
        }
        for(int i=count + count1;i<nums.length;i++){
            nums[i]=2;
        }

    }
}