class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;

        for (int i = 0; i < n - 1; i++) {

            // component continues
            if (prefixMax[i] > suffixMin[i + 1]) {
                continue;
            }

            // finalize current component
            int mx = Integer.MIN_VALUE;

            for (int j = start; j <= i; j++) {
                mx = Math.max(mx, nums[j]);
            }

            for (int j = start; j <= i; j++) {
                ans[j] = mx;
            }

            start = i + 1;
        }

        // last component
        int mx = Integer.MIN_VALUE;

        for (int i = start; i < n; i++) {
            mx = Math.max(mx, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = mx;
        }

        return ans;
    }
}