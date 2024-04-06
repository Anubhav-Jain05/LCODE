class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices,0,1,new HashMap<String,Integer>());
    }
    private int maxProfit(int[] prices,int currentday,int canbuy,HashMap<String,Integer>map){
        if(currentday >= prices.length)return 0;
        String currentKey=currentday +"-"+canbuy;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canbuy==1){
            int ideal=maxProfit(prices,currentday + 1,canbuy,map);
            int buy= - prices[currentday] + maxProfit(prices,currentday +1 ,0,map);
            ans=Math.max(ideal,buy);
        }else{
            int ideal=maxProfit(prices,currentday +1,canbuy,map);
            int sell = prices[currentday] + maxProfit(prices,currentday + 2,1,map);
            ans=Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}