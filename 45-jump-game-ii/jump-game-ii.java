class Solution {
    public int jump(int[] nums) {
        return minJump(nums,0,new HashMap<Integer,Integer>());
    }
    private int minJump(int[] nums,int currentIndex,HashMap<Integer,Integer>map){
        if(currentIndex >= nums.length-1)return 0;
        if(nums[currentIndex] == 0)return 10001;
        int currentKey=currentIndex;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=10001;
        int currJump=nums[currentIndex];
        for(int i=1;i<=currJump;i++){
            int doJump=1+minJump(nums,currentIndex + i,map);
            ans=Math.min(doJump,ans);
        }
        map.put(currentKey,ans);
        return ans;
    }
}