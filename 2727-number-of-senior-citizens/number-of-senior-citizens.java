class Solution {
    public int countSeniors(String[] details) {
        int count =0;

        for(String str:details){
            char tens=str.charAt(11);
            char ones=str.charAt(12);
            if(tens > '6' || (tens == '6' && ones > '0')){
                count++;
            }
        }
        return count;
    }
}