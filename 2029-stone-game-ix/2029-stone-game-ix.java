class Solution {
    public boolean stoneGameIX(int[] stones) {
         int[] counts = new int[3];
        for (int stone : stones) {
            counts[stone % 3]++;
        }
        
        int rem0 = counts[0];
        int rem1 = counts[1];
        int rem2 = counts[2];
        
        if (rem0 % 2 == 0) {
            return rem1 > 0 && rem2 > 0;
        }
        
        return Math.abs(rem1 - rem2) > 2;
    }
}