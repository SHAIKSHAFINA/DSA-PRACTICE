import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // last[j] stores the maximum index in word1 from which 
        // the suffix word2[j...] can be matched completely without any modifications.
        int[] last = new int[m + 1];
        Arrays.fill(last, -1);
        last[m] = n;
        
        // Step 1: Precompute suffix matchings from right to left
        int w1Idx = n - 1;
        for (int w2Idx = m - 1; w2Idx >= 0; w2Idx--) {
            while (w1Idx >= 0 && word1.charAt(w1Idx) != word2.charAt(w2Idx)) {
                w1Idx--;
            }
            if (w1Idx >= 0) {
                last[w2Idx] = w1Idx;
                w1Idx--; // Move to next available character in word1
            } else {
                break;
            }
        }
        
        int[] ans = new int[m];
        boolean changed = false;
        int w2Idx = 0;
        
        // Step 2: Greedy matching from left to right
        for (int i = 0; i < n && w2Idx < m; i++) {
            // Case 1: Characters match perfectly
            if (word1.charAt(i) == word2.charAt(w2Idx)) {
                ans[w2Idx] = i;
                w2Idx++;
            } 
            // Case 2: Mismatch, try using our single modification
            else if (!changed && last[w2Idx + 1] > i) {
                ans[w2Idx] = i;
                w2Idx++;
                changed = true;
            }
        }
        
        // If we matched all characters of word2, return the sequence; otherwise return an empty array
        return w2Idx == m ? ans : new int[0];
    }
}
