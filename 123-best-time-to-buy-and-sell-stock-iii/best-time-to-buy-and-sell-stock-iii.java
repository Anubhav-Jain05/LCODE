class Solution {
    public int maxProfit(int[] prices) {
         return maxProfits(prices,0,1,2,new HashMap<String,Integer>());
    }
    private int maxProfits(int[] prices,int currentIndex,int canBuy,int transCount,HashMap<String,Integer>map){
        if(currentIndex >= prices.length || transCount == 0)return 0;
        String currentKey=currentIndex +"-"+canBuy+"-"+transCount;

        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans=0;
        if(canBuy==1){
            int ideal=maxProfits(prices,currentIndex + 1,canBuy,transCount,map);
            int buy=-prices[currentIndex] + maxProfits(prices,currentIndex + 1,0,transCount,map);
            ans=Math.max(ideal,buy);
        }
        else{
            int ideal=maxProfits(prices,currentIndex + 1,canBuy,transCount,map);
            int sell=prices[currentIndex] + maxProfits(prices,currentIndex + 1,1,transCount-1,map);
            ans=Math.max(ideal,sell);
        }
        map.put(currentKey,ans);
        return ans;
    }
}