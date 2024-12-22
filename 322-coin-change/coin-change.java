class Solution {
  public int coinChange(int[] coins,int amount) {
        int ans= totalWays(amount,0,coins,new HashMap<String,Integer>());
        if(ans== 10001)return -1;
        return ans;
    }
    private int totalWays(int amt,int currentIndex,int[] coins,HashMap<String,Integer>map){
        if(amt == 0)return 0;
        if(currentIndex == coins.length)return 10001;
        String currentKey=Integer.toString(currentIndex) + "-" + Integer.toString(amt);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int current_coin=coins[currentIndex];
        int consider=10001;
        if(current_coin <= amt){
            consider=1 + totalWays(amt-current_coin,currentIndex,coins,map);
        }
        int notConsider=totalWays(amt,currentIndex + 1,coins,map);
        map.put(currentKey,Math.min(consider,notConsider));
        return  map.get(currentKey);
    }
}