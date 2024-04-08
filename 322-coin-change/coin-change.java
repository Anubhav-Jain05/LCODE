class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans= minimumWays(coins,0,amount,new HashMap<String,Integer>());

        if(ans == 10001)return -1;

        return ans;
    }
    private int minimumWays(int [] coins,int currentIndex,int amt,HashMap<String,Integer>map){
        if(amt == 0)return 0;
        if(currentIndex == coins.length)return 10001;

        int currentCoin=coins[currentIndex];
        String currKey=Integer.toString(currentIndex) + "-"+ Integer.toString(amt);
        if(map.containsKey(currKey)){
           return  map.get(currKey);
        }
        int consider =10001;
        if(currentCoin <= amt){
            consider= 1 + minimumWays(coins,currentIndex,amt-currentCoin,map);
        }
        int notConsider=minimumWays(coins,currentIndex + 1,amt,map);
        map.put(currKey, Math.min(consider,notConsider));
        return map.get(currKey);
    }
}