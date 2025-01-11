class Solution {
    public int strStr(String haystack, String needle) {
        int haystacklength=haystack.length();
        int needlelen=needle.length();
        for(int i=0;i<=haystacklength-needlelen;i++){
            int j=0;
            while(j < needlelen && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == needlelen)return i;
        }
        return -1;
    }
}