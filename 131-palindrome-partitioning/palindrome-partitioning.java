class Solution {
   public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int end = start + 1; end <= s.length(); end++) {
                if (isPalindrome(s, start, end - 1)) {
                    tempList.add(s.substring(start, end));
                    backtrack(result, tempList, s, end);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}