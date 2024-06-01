class Solution {
    public int scoreOfString(String s) {
        int score =0;
        for(int i=1;i<s.length();i++){
            int prevchar=s.charAt(i-1);
            int currChar=s.charAt(i);

            score += Math.abs(prevchar -currChar);
        }
        return score;
    }
}