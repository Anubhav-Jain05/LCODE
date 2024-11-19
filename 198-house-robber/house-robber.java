class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        return maximumamt(nums,0,map);
    }
    private int maximumamt(int[] nums,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int rob=nums[currentIndex] + maximumamt(nums,currentIndex  + 2,map);
        int notrob=maximumamt(nums,currentIndex +1,map);
        map.put(currentKey,Math.max(rob,notrob));
        return map.get(currentKey);
    }
}