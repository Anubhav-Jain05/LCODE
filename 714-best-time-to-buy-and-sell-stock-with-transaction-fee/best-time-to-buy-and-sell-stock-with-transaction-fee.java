class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maxProfits(prices,0,1,fee,new HashMap<String,Integer>());
    }
     private int maxProfits(int[] prices,int currentIndex,int canBuy,int fee,HashMap<String,Integer>map){
        if(currentIndex >= prices.length)return 0;
        String currentKey=currentIndex +"-"+canBuy;

        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canBuy==1){
            int ideal=maxProfits(prices,currentIndex + 1,canBuy,fee,map);
            int buy=-prices[currentIndex] + maxProfits(prices,currentIndex + 1,0,fee,map);
            ans=Math.max(ideal,buy);
        }
        else{
            int ideal=maxProfits(prices,currentIndex + 1,canBuy,fee,map);
            int sell=(prices[currentIndex] - fee) + maxProfits(prices,currentIndex + 1,1,fee,map);
            ans=Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}