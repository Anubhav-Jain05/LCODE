class Solution {
    public int change(int amount, int[] coins) {
        return  totalWays(amount,coins,0,new HashMap<String,Integer>());
    }
    private int totalWays(int amt,int[] coins,int currentIndex,HashMap<String,Integer>map){
        if(amt == 0)return 1;
        if(currentIndex == coins.length)return 0;
        String currentKey=currentIndex +"-"+amt;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int curr_coins=coins[currentIndex];
        int consider =0;
        if(curr_coins <= amt){
            consider=totalWays(amt-curr_coins,coins,currentIndex,map);
        }
        int notconsider=totalWays(amt,coins,currentIndex +1,map);
        map.put(currentKey,consider + notconsider);
        return map.get(currentKey);
    }
}