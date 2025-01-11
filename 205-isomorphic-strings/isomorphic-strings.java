class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        int[] s_res=new int[256];
        int[] t_res=new int[256];
        for(int i=0;i<s.length();i++){
            char s_ch=s.charAt(i);
            char t_ch=t.charAt(i);
            if(s_res[s_ch] == 0 && t_res[t_ch] == 0){
                s_res[s_ch]=t_ch;
                t_res[t_ch]=s_ch;
            }else{
                if(s_res[s_ch] != t_ch || t_res[t_ch] != s_ch){
                    return false;
                }
            }
        }
        return true;
    }
}