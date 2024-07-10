class Solution {
    public int minOperations(String[] logs) {
        Stack<String> path=new Stack<>();
        for(String log : logs){
            if(log.equals("../")){
                if(!path.isEmpty()){
                    path.pop();
                }
            }else if(!log.equals("./")){
                path.push(log);
            }
        }
        return path.size();
    }
}