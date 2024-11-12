class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return -1;
        // int count=0;
        // int ele=0;
        // for(int i=0;i<nums.length;i++){
        //     if(count==0){
        //         count=1;
        //         ele=nums[i];
        //     }else if(ele == nums[i]){
        //         count++;
        //     }else{
        //         count--;
        //     }
        // }   
        // int count1=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==ele)count1++;
        // }
        // if(count1 > nums.length/2){
        //     return ele;
        // }
        // return -1;
    }
}