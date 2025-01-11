class Solution {
    public boolean isPalindrome(String s) {
        return isPalin(s,0,s.length()-1);
    }
    private boolean isPalin(String s,int left,int right){
        if(left >= right)return true;
        if(!Character.isLetterOrDigit(s.charAt(left))){
            return isPalin(s,left + 1,right);
        }
        if(!Character.isLetterOrDigit(s.charAt(right))){
            return isPalin(s,left,right -1);
        }
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }
        return isPalin(s,left+1,right-1);
    }
}