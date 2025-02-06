class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans=minCoin(coins,amount,0,new HashMap<String,Integer>());
        if(ans == 100001)return -1;
        return ans;
    }
    private int minCoin(int[] coins,int amt,int currentIndex,HashMap<String,Integer>map){
        if(amt == 0)return 0;
        if(currentIndex == coins.length)return 100001;
        String currentKey=currentIndex +"-"+amt;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int curr_coins=coins[currentIndex];
        int consider=100001;
        if(curr_coins <= amt){
            consider = 1 + minCoin(coins,amt - curr_coins,currentIndex,map);
        }
        int notconsider=minCoin(coins,amt,currentIndex + 1,map);
        map.put(currentKey,Math.min(consider,notconsider));
        return map.get(currentKey);
    }
}