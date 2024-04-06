class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maxProfitByFee(prices,0,1,fee,new HashMap<String,Integer>());
    }
    private int maxProfitByFee(int[] prices,int currentday,int canbuy,int fee,HashMap<String,Integer>map){
        if(currentday >= prices.length)return 0;
        String currentKey=currentday +"-"+canbuy;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canbuy == 1){
            int ideal=maxProfitByFee(prices,currentday +1,canbuy,fee,map);
            int buy= - prices[currentday] + maxProfitByFee(prices,currentday +1 ,0,fee,map);
            ans=Math.max(ideal,buy);
        }else{
            int ideal=maxProfitByFee(prices,currentday + 1,canbuy,fee,map);
            int sell= (prices[currentday]-fee) + maxProfitByFee(prices,currentday +1,1,fee,map);
            ans=Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}