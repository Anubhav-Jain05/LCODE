class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        HashMap<Character,Integer> map= new HashMap<>();
        int release =0;

        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);

            while(release < i && map.containsKey(ch)){
                char discard = s.charAt(release);
                map.remove(discard);
                release += 1;
            }

            map.put(ch,i);
            ans= Math.max(ans,i-release + 1);
        }
        return ans;

    }
}