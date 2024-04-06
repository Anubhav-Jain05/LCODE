class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices,0,1,k,new HashMap<String,Integer>());
    }
    private int maxProfit(int[] prices,int currentDay,int canBuy,int transcount,HashMap<String,Integer>map){
        if(currentDay >= prices.length || transcount == 0)return 0;
        String currentKey=currentDay +"-"+canBuy+"-"+transcount;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canBuy == 1){
            int ideal= maxProfit(prices,currentDay + 1,canBuy,transcount,map);
            int buy= - prices[currentDay] + maxProfit(prices,currentDay +1 ,0,transcount,map);
            ans=Math.max(ideal,buy);
        }else{
            int ideal = maxProfit(prices,currentDay +1,canBuy,transcount,map);
            int sell=prices[currentDay] + maxProfit(prices,currentDay +1 ,1,transcount-1,map);
            ans=Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}