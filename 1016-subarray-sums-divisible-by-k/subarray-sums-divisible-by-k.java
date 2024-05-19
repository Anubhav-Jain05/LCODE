class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans=0;
        int prefixSum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(prefixSum,1);

        for(int currentVal : nums){
            prefixSum += currentVal;
            int currentrem=((prefixSum % k) + k)%k;

            if(map.containsKey(currentrem)){
                ans += map.get(currentrem);
                map.put(currentrem,map.get(currentrem) + 1);
            }else{
                map.put(currentrem,1);
            }
        }
        return ans;

    }
}