class Solution {
    public int findDuplicate(int[] nums) {
        // int slow=nums[0];
        // int fast=nums[0];
        // do{
        //     slow=nums[slow];
        //     fast=nums[nums[fast]];
        // }while(slow != fast);
        // fast=nums[0];
        // while(slow != fast){
        //     slow=nums[slow];
        //     fast=nums[fast];
        // }
        // return slow;

        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}