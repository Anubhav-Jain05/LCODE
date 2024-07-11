class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ans);
                ans=new StringBuilder();
            }else if(ch == ')'){
                ans.reverse();
                ans=stack.pop().append(ans);
            }else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}