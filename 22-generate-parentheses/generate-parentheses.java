class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        findall(0,0,"",n,ans);
        return ans;

    }
    private void findall(int openCount,int closeCount,String expression,int n,List<String> ans){
        if(openCount == closeCount && openCount == n){
            ans.add(expression);
            return;
        }
        if(openCount < n){
            findall(openCount + 1,closeCount,expression + "(",n,ans);
        }
        if(openCount > closeCount){
            findall(openCount,closeCount + 1,expression + ")",n,ans);
        }
        return;
    }
}