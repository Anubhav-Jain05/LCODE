class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int prefixSum=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(prefixSum,1);

        for(int currentVal : nums){
            prefixSum += currentVal;

            if(map.containsKey(prefixSum-k)){
                ans += map.get(prefixSum-k);
            }
            if(map.containsKey(prefixSum)){
                map.put(prefixSum,map.get(prefixSum) + 1);
            }else{
                map.put(prefixSum,1);
            }
        }
        return ans;
    }
}