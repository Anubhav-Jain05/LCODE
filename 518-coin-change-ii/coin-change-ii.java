class Solution {
    public int change(int amount, int[] coins) {
        return totalWays(coins,0,amount,new HashMap<String,Integer>());
    }
    private int totalWays(int[] coins,int currentIndex,int amt,HashMap<String,Integer> map){
        if(amt == 0)return 1;
        if(currentIndex == coins.length)return 0;
        String currentKey=Integer.toString(currentIndex) +"-"+Integer.toString(amt);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int currentCoin=coins[currentIndex];
        int consider = 0;
        if(currentCoin <= amt){
            consider= totalWays(coins,currentIndex,amt-currentCoin,map);
        }
        int not_consider=totalWays(coins,currentIndex + 1,amt,map);
        map.put(currentKey,consider + not_consider);
        return map.get(currentKey);
    }
}