class Solution {
    public int rob(int[] nums) {
        return maxamt(nums,0,new HashMap<Integer,Integer>());
    }
    private int maxamt(int[] nums,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int get_money=nums[currentIndex] + maxamt(nums,currentIndex + 2,map);
        int not_get_money= maxamt(nums,currentIndex + 1,map);

        map.put(currentKey,Math.max(get_money,not_get_money));
        return map.get(currentKey);
    }
}