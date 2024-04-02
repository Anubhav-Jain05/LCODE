class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> smap=new HashMap<>();
        HashMap<Character,Character> tmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char s1=s.charAt(i);
            char t1=t.charAt(i);
            if(smap.containsKey(s1) && smap.get(s1) != t1 || tmap.containsKey(t1) && tmap.get(t1) != s1){
                return false;
            }
            
            smap.put(s1,t1);
            tmap.put(t1,s1);
        }
        return true;

        // HashMap<Character,Character> map = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char s1=s.charAt(i);
        //     char t1=t.charAt(i);
        //     if(map.containsKey(s1)){
        //         if(map.get(s1).equals(t1)){
        //             continue;
        //         }else{
        //             return false;
        //         }
        //     }else{
        //         if(!map.containsValue(t1)){
        //             map.put(s1,t1);
        //         }else{
        //             return false;
        //         }
        //     }
        // }
        // return true;
    }
}