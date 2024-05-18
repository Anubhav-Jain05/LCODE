class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countdistinct(nums,k) - countdistinct(nums,k-1);
    }
    private int countdistinct(int[] nums,int k){
        int ans=0;
        int release=0;
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int currentVal=nums[i];
            if(map.containsKey(currentVal)){
                map.put(currentVal,map.get(currentVal)+1);
            }else{
                map.put(currentVal,1);
            }

            while(release <=  i && map.size() > k){
                int disValue=nums[release];
                map.put(disValue,map.get(disValue) -1);
                release ++;

                if(map.get(disValue) == 0){
                    map.remove(disValue);
                }
            }
            ans +=i - release + 1; // i== acquire 
        }
        return ans;
    }
}