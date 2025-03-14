class Solution {
    public int minCut(String s) {
        return minimumcut(s,0,s.length()-1,new HashMap<>());
    }
    private int minimumcut(String s,int start,int end,HashMap<String,Integer>map){
        if(isPalindrome(s,start,end)){
            return 0;
        }
        String currentkey=Integer.toString(start);
        if(map.containsKey(currentkey)){
            return map.get(currentkey);
        }
        int ans=1000000;
        for(int i=start;i<end;i++){
            if(isPalindrome(s,start,i)){
                int temp=1+minimumcut(s,i+1,end,map);
                ans=Math.min(ans,temp);
            }
        }
        map.put(currentkey,ans);
        return ans;
    }
    private boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end--;

        }
        return true;
    }
}