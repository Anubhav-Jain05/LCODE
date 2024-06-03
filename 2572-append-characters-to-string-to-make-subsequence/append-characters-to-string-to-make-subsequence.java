class Solution {
    public int appendCharacters(String s, String t) {
        int spointer=0;
        int tpointer=0;

        while(spointer < s.length() && tpointer < t.length()){
            if(s.charAt(spointer) == t.charAt(tpointer)){
                tpointer++;
            }
            spointer++;
        }
        return t.length()-tpointer;
    }
}