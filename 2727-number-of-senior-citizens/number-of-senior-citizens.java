class Solution {
    public int countSeniors(String[] details) {
       int count=0;
       for(String str : details){
         char first=str.charAt(11);
         char second=str.charAt(12);
         if(first > '6' || (first == '6' && second > '0')){
            count++;
         }
       }
       return count;
    }
}