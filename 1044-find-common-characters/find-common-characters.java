class Solution {
    public List<String> commonChars(String[] A) {
          int[] commonCount = new int[26];
        Arrays.fill(commonCount, Integer.MAX_VALUE);

        // Update the frequency array to keep only common characters
        for (String word : A) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                commonCount[i] = Math.min(commonCount[i], count[i]);
            }
        }

        // Construct the result list from the frequency array
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < commonCount[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}