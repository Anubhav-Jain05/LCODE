class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int[] res= new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }
            map.put(nums[i],i);
        }
        return res;
       
    //    HashMap<Integer,Integer> map =new HashMap<>();
    //    int[] res= new int[2];
    //    for(int i=0;i<nums.length;i++){
    //        if(map.containsKey(target-nums[i])){
    //            res[0]=map.get(target-nums[i]);
    //            res[1]=i;
    //        }
    //        map.put(nums[i],i);
    //    }
    //    return res;
        // HashMap<Integer,Integer> hs= new HashMap<>();
        // int[] res= new int[2];
        // for(int i=0;i<nums.length;i++){
        //     if(hs.containsKey(target-nums[i])){
        //         res[0]=hs.get(target-nums[i]);
        //         res[1]=i;
        //     }
        //     hs.put(nums[i],i);
        // }
        // return res;
        // int[] res= new int[2];
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i] + nums[j] == target){
        //             res[0]=i;
        //             res[1]=j;
        //         }
        //     }
        // }
        // return res;

        
        

        

    //    HashMap<Integer,Integer> map=new HashMap<>();
    //    int[] res= new int[2];
    //    for(int i=0;i<nums.length;i++){
    //        if(map.containsKey(target-nums[i])){
    //            res[0]=map.get(target-nums[i]);
    //            res[1]=i;
    //            return res;
    //        }
    //        map.put(nums[i],i);
    //    }
    //    return res;

        // int [] res= new int[2];
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             res[0]=i;
        //             res[1]=j;
        //         }
        //     }
        // }
        // return res;
    }
}