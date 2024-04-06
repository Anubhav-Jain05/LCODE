class Solution {
    public int maxProfit(int[] prices) {
      return maxProfit(prices,0,1,1,new HashMap<String,Integer>());
      //0= 0 th day,1=buy the stoack or not , 1 = number of transaction allowed
    }
    private int maxProfit(int[] prices,int currentDay,int canBuy,int transcount,HashMap<String,Integer> memo){
        if(currentDay >= prices.length)return 0;

        if(transcount == 0)return 0;

        String currentKey= currentDay +"-" + canBuy +"-" + transcount;

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int ans =0;
        if(canBuy == 1){
            int ideal = maxProfit(prices, currentDay + 1, canBuy, transcount,memo);
            int buy = - prices[currentDay] + maxProfit(prices,currentDay + 1,0,transcount,memo);
            // return Math.max(ideal,buy);
            ans=Math.max(ideal,buy);
        }else{
            int ideal = maxProfit(prices, currentDay + 1, canBuy, transcount,memo);
            int sell = prices[currentDay] + maxProfit(prices,currentDay + 1,0,transcount-1,memo);
            // return Math.max(ideal,sell);
            ans=Math.max(ideal,sell);

        }
        memo.put(currentKey,ans);
        return ans;
    }
}