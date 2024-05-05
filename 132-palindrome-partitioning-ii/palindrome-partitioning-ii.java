class Solution {
    public int minCut(String s) {
        return minimumCut(s,0,s.length()-1,new HashMap<String,Integer>());
    }
    private int minimumCut(String s,int start,int end,HashMap<String,Integer>memo){
        if(isPlaindrome(s,start,end)){
            return 0;
        }
        int ans= 1000000;
        // String currentKey=start +"-"+end;
        String currentKey=Integer.toString(start); //O(n)
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        for(int i=start;i<end;i++){ // line no 15 and 16 TC will be O(n2)
            if(isPlaindrome(s,start,i)){ 
                // check if the left half is palindrome then we have 
                // make a cut otherwise we have not make a cut
                int tempans=1+minimumCut(s,i+1,end,memo);
                ans=Math.min(tempans,ans);
            }
        }
        memo.put(currentKey,ans);
        return ans;
    }
    private boolean isPlaindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start +=1;
            end -=1;
        }
        return true;
    }
}