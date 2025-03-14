class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return totalways(n,k,target,new HashMap<>());
    }
    private int totalways(int n,int k,int target,HashMap<String,Integer>map){
        if(n == 0 && target == 0)return 1;
        if(n == 0 || target <= 0)return 0;
        String currentkey=n + "-" + target;
        if(map.containsKey(currentkey)){
            return map.get(currentkey);
        }
        int ways=0;
        int mod=1000000007;
        for(int i=1;i<=k;i++){
            int temp=totalways(n-1,k,target-i,map);
            ways=ways % mod;
            ways=(ways + temp) % mod;

        }
        map.put(currentkey,ways);
        return ways;

    }
}