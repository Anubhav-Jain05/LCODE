class Solution {
    public int change(int amount, int[] coins) {
        return totalWays(amount,0,coins,new HashMap<String,Integer>());
    }
    private int totalWays(int amt,int currentIndex,int[] coins,HashMap<String,Integer>map){
        if(amt == 0)return 1;
        if(currentIndex == coins.length)return 0;
        String currentKey=Integer.toString(currentIndex) + "-" + Integer.toString(amt);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int current_coin=coins[currentIndex];
        int consider=0;
        if(current_coin <= amt){
            consider=totalWays(amt-current_coin,currentIndex,coins,map);
        }
        int notConsider=totalWays(amt,currentIndex + 1,coins,map);
        map.put(currentKey,consider+notConsider);
        return  map.get(currentKey);
    }
}