class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        return maxAmt(nums,0,map);
    }
    private int maxAmt(int[] nums,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex >= nums.length)return 0;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int getAmt=nums[currentIndex] + maxAmt(nums,currentIndex + 2,map);
        int notgteAmt=maxAmt(nums,currentIndex + 1,map);
        map.put(currentKey,Math.max(getAmt,notgteAmt));
        return map.get(currentKey);
    }
}