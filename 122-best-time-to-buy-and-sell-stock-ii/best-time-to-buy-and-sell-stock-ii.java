class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices,0,1,new HashMap<String,Integer>());
    }
    private int maxProfit(int[] prices,int currentDay,int canBuy,HashMap<String,Integer>map){
        if(currentDay >= prices.length)return 0;
        String currentKey=currentDay +"-" + canBuy;
        if(map.containsKey(currentKey)){
           return  map.get(currentKey);
        }
        int ans =0;
        if(canBuy == 1){
            int ideal = maxProfit(prices,currentDay + 1,canBuy,map);
            int buy= - prices[currentDay] + maxProfit(prices,currentDay  + 1,0,map);
            ans = Math.max(ideal,buy);
        }
        else {
            int ideal=maxProfit(prices,currentDay +1,canBuy,map);
            int sell= prices[currentDay] + maxProfit(prices,currentDay +1, 1,map);
            ans = Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}