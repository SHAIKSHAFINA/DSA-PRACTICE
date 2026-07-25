class Solution {
    public int maxProduct(int n) {
        int max = -1, max2 = -1;

        while (n > 0) {
            int d = n % 10;

            if (d > max) {
                max2 = max;
                max = d;
            } else if (d > max2) {
                max2 = d;
            }

            n /= 10;
        }

        return max * max2;
    }
}