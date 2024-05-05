class Solution {
    public int minDistance(String s1, String s2) {
        return minimum_op(s1,s2,0,0,s1.length(),s2.length(),new HashMap<String,Integer>());
    }
    private int minimum_op(String s1,String s2,int i ,int j,int n,int m,HashMap<String,Integer>map){
        if(j >= m)return n-i;
        if(i >= n)return m-j;
        int ans=1000000;
        String currentKey=i +"-" + j;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        if(s1.charAt(i)== s2.charAt(j)){
            ans=minimum_op(s1,s2,i+1,j+1,n,m,map);
        }else{
            int insertion= 1 + minimum_op(s1,s2,i,j+1,n,m,map);
            int deletion= 1 + minimum_op(s1,s2,i+1,j,n,m,map);
            int replace= 1 + minimum_op(s1,s2,i+1,j+1,n,m,map);
            ans=Math.min(insertion,Math.min(deletion,replace));
        }
        map.put(currentKey,ans);
        return ans;
    }

}