class Solution {
    public String makeGood(String s) {
        // StringBuilder result= new StringBuilder();

        // for(char ch : s.toCharArray()){
        //     if(result.length() > 0 && Math.abs(result.charAt(result.length()-1)-ch) == 32){
        //         result.deleteCharAt(result.length()-1);
        //     }
        //     else{
        //         result.append(ch);
        //     }
        // }
        // return result.toString();

        Stack<Character> stack= new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek() - ch)== 32){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        StringBuilder res=  new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}