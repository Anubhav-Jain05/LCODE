class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return totalways(n,k,target,new HashMap<>());
    }
    private int totalways(int n,int f,int targetSum,HashMap<String,Integer>map){//f== faces (no.of faces)
        if(n==0 && targetSum ==0)return 1;
        if(n==0 || targetSum <= 0)return 0;
        String currentKey= n + "-" + targetSum;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ways=0;
        int mod=1000000007;
        for(int i=1;i<=f;i++){
          int tempans = totalways(n-1,f,targetSum - i,map) % mod;
            ways=ways % mod;
            ways=(ways + tempans) % mod;

        }
        map.put(currentKey,ways);
        return ways;
    }
}