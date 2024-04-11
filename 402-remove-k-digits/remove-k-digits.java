class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)return "0";
        Stack<Character> stack= new Stack<>();
        for(char ch : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder result= new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        while(result.length() > 0 && result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        return result.length() > 0 ? result.toString() : "0";
    }
}