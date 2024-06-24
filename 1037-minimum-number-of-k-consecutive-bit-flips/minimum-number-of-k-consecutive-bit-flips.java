class Solution {
    public int minKBitFlips(int[] A, int K) {
          int n = A.length;
        int[] flip = new int[n];
        int flipCount = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i >= K) {
                flipCount ^= flip[i - K];
            }

            if ((A[i] ^ flipCount) == 0) {
                if (i + K > n) {
                    return -1;
                }
                flipCount ^= 1;
                flip[i] = 1;
                result++;
            }
        }

        return result;
    }
}