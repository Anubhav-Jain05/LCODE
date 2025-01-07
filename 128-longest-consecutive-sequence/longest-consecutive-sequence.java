class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int maxlen=0;
        HashSet<Integer> set= new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int currentnum=num;
                int currentLength=1;
                while(set.contains(currentnum + 1)){
                    currentnum++;
                    currentLength++;
                }
                maxlen=Math.max(currentLength,maxlen);
            }
            
        }
        return maxlen;
    }
}