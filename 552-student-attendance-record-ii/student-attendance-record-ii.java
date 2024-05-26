class Solution {
  private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        // dp[i][j][k] means the number of valid sequences of length i, with j 'A's, ending with k consecutive 'L's
        long[][][] dp = new long[n + 1][2][3];

        // Base case: an empty sequence
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    // If adding 'P' (present)
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;

                    // If adding 'A' (absent)
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                    }

                    // If adding 'L' (late)
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                    }
                }
            }
        }

        // Sum up all valid sequences of length n
        long result = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return (int) result;
    }
}