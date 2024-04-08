class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        maxCombination(result,"",0,0,n);
        return result;
    }
    public void maxCombination(List<String> res,String curr,int openCount,int closeCount,int n){
        if(curr.length() == 2 * n){
            res.add(curr);
            return ;
        }
        if(openCount < n){
            maxCombination(res,curr + "(",openCount + 1,closeCount,n);
        }
        if(closeCount < openCount){
            maxCombination(res,curr + ")",openCount,closeCount + 1,n);
        }
    }
}