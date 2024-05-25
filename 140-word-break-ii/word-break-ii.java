class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>(wordDict);
        HashMap<String,List<String>> map=new HashMap<>();
        return wordbreakhelper(s,wordSet,map);
    }
    private List<String> wordbreakhelper(String s,Set<String> wordSet,HashMap<String,List<String>> map) {
        if(map.containsKey(s)){
           return map.get(s);
        }
        List<String> result=new ArrayList<>();

        if(wordSet.contains(s)){
            result.add(s);
        }
        for(int i=1;i<s.length();i++){
            String right = s.substring(i);
            if(wordSet.contains(right)){
                String left=s.substring(0,i);
                List<String> leftresult=wordbreakhelper(left,wordSet,map);
                for(String leftString:leftresult){
                    result.add(leftString +" "+ right);
                }
            }
        }
        map.put(s,result);
        return result;
    }
}