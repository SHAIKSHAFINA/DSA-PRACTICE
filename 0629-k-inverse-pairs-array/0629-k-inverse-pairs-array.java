class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;
        long[] dp = new long[k + 1];

        dp[0] = 1; // Base case: 1 way to have 0 inversions with 1 element

        for (int i = 2; i <= n; i++) {
            long[] newDp = new long[k + 1];
            newDp[0] = 1; // 0 inversions is always possible

            for (int j = 1; j <= k; j++) {
                // Formula: dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-i]
                long sub = (j - i >= 0) ? dp[j - i] : 0;
                newDp[j] = (newDp[j - 1] + dp[j] - sub + MOD) % MOD;
            }

            dp = newDp; // Update dp for next iteration
        }

        return (int) dp[k];
    }
}
