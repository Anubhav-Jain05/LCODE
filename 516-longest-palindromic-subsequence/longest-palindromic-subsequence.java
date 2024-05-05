class Solution {
    public int longestPalindromeSubseq(String s) {
        return LPS(s,new StringBuilder(s).reverse().toString());
    //     return LCS(s,new StringBuilder(s).reverse().toString(),0,0,s.length(),s.length(),new HashMap<String,Integer>());
    // }
    // private int LCS(String s1,String s2,int i ,int j,int n,int m, HashMap<String,Integer> map){
    //     if(i >= n || j >= m)return 0;
    //     int ans =0;
    //     String currentKey= i +"-"+j; 
    //     // TC depends on i and j where i is go to the length of n and j is go to the length of m
    //     // so the TC will be O(n * m) and SC will be same 
    //     if(map.containsKey(currentKey)){
    //         return map.get(currentKey);
    //     }
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         ans = 1 + LCS(s1,s2,i + 1,j + 1,n,m,map);
    //     }else{
    //         int consider_i=LCS(s1,s2,i,j+1,n,m,map);
    //         int consider_j=LCS(s1,s2,i+1,j,n,m,map);
    //         ans=Math.max(consider_i,consider_j);
    //     }
    //     map.put(currentKey,ans);
    //     return ans;
    }
    private int LPS(String text1,String text2){ 
        int n=text1.length();
        int m=text2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i=1;i<n + 1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    
}