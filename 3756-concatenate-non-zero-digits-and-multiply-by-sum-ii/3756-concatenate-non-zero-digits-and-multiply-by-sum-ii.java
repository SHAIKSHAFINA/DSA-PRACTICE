class Solution {
    static final long MOD = 1000000007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Prefix sum of original digits
        int[] digitSum = new int[n + 1];

        // Position of non-zero digits
        int[] pos = new int[n + 1];

        StringBuilder nz = new StringBuilder();

        for (int i = 0; i < n; i++) {
            digitSum[i + 1] = digitSum[i] + (s.charAt(i) - '0');

            pos[i + 1] = pos[i];
            if (s.charAt(i) != '0') {
                nz.append(s.charAt(i));
                pos[i + 1]++;
            }
        }

        int m = nz.length();

        long[] hash = new long[m + 1];
        long[] pow = new long[m + 1];
        pow[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
            hash[i] = (hash[i - 1] * 10 + (nz.charAt(i - 1) - '0')) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitSum[r + 1] - digitSum[l];

            int left = pos[l];
            int right = pos[r + 1];

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            long x = (hash[right] - (hash[left] * pow[right - left]) % MOD + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}