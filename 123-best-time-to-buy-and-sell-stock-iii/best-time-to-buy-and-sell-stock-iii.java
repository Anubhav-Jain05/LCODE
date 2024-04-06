class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices,0,1,2,new HashMap<String,Integer>());
    }
    private int maxProfit(int[] prices,int currentday,int canbuy,int transcount,HashMap<String,Integer>map){
        if(currentday >= prices.length || transcount == 0){
            return 0;
        }
        String currentKey=currentday + "-"+canbuy+"-"+transcount;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canbuy==1){
            int ideal=maxProfit(prices,currentday +1,canbuy,transcount,map);
            int buy= - prices[currentday] + maxProfit(prices,currentday + 1,0,transcount,map);
            ans=Math.max(ideal,buy);
        }else{
            int ideal=maxProfit(prices,currentday +1 ,canbuy,transcount,map);
            int sell= prices[currentday] + maxProfit(prices,currentday +1,1,transcount-1,map);
            ans= Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}