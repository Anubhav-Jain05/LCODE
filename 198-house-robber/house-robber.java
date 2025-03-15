class Solution {
    public int rob(int[] nums) {
        return maximumamt(nums,0,new HashMap<>());
    }
    private int maximumamt(int[] nums,int currentIndex,HashMap<Integer,Integer> map){
        if(currentIndex >= nums.length)return 0;
        // if(currentIndex > nums.length)return 10001;
        int currentkey=currentIndex;
        if(map.containsKey(currentkey)){
            return map.get(currentkey);
        }
        int rob=nums[currentIndex] + maximumamt(nums,currentIndex + 2,map);
        int not_rob=maximumamt(nums,currentIndex +1,map);

        map.put(currentkey,Math.max(rob,not_rob));
        return map.get(currentkey);
    }
}