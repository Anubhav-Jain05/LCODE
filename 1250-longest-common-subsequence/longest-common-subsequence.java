class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        return LCS(s1,s2,0,0,s1.length(),s2.length(),new HashMap<String,Integer>());
    }
    private int LCS(String s1,String s2,int i ,int j,int n,int m, HashMap<String,Integer> map){
        if(i >= n || j >= m)return 0;
        int ans =0;
        String currentKey= i +"-"+j; 
        // TC depends on i and j where i is go to the length of n and j is go to the length of m
        // so the TC will be O(n * m) and SC will be same 
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + LCS(s1,s2,i + 1,j + 1,n,m,map);
        }else{
            int consider_i=LCS(s1,s2,i,j+1,n,m,map);
            int consider_j=LCS(s1,s2,i+1,j,n,m,map);
            ans=Math.max(consider_i,consider_j);
        }
        map.put(currentKey,ans);
        return ans;
    }
}