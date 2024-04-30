class Solution {
    public long wonderfulSubstrings(String word) {
          long[] count = new long[1024]; // 10 bits for each character ('a' to 'j')
        count[0] = 1; // Empty string is wonderful
        int mask = 0;
        long result = 0;

        for (char ch : word.toCharArray()) {
            mask ^= 1 << (ch - 'a'); // Toggle the bit corresponding to the current character

            // Count all substrings where only one character has odd frequency
            result += count[mask];

            // Count all substrings where all characters have even frequency except one
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }

            count[mask]++; // Update the count for the current mask
        }

        return result;
    }
}