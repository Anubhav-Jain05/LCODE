class Solution {
    private static final String[] keys_mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        generateComb(digits,0,"",ans);
        return ans;
    }
    private void generateComb(String digits,int currentIndex,String currentString,List<String> ans){
        if(currentIndex >= digits.length()){
            ans.add(currentString);
            return;
        }
        String letters=keys_mapping[digits.charAt(currentIndex) - '0'];
        for(int i=0;i<letters.length();i++){
            generateComb(digits,currentIndex + 1,currentString + letters.charAt(i),ans);   
        }
        return;
    }
}
