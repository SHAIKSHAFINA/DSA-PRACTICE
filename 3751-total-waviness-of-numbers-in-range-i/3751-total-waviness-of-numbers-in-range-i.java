class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += waviness(num);
        }

        return total;
    }

    private int waviness(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        if (digits.length < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < digits.length - 1; i++) {
            int prev = digits[i - 1] - '0';
            int curr = digits[i] - '0';
            int next = digits[i + 1] - '0';

            
            if (curr > prev && curr > next) {
                count++;
            }
            
            else if (curr < prev && curr < next) {
                count++;
            }
        }

        return count;
    }
}