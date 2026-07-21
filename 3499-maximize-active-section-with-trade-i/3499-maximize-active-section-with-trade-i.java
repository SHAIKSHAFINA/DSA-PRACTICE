class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }

        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == ch) j++;

            type.add(ch);
            len.add(j - i);

            i = j;
        }

        int ans = ones;

        for (int k = 1; k < type.size() - 1; k++) {
            if (type.get(k) == '1') {
                ans = Math.max(ans,
                        ones + len.get(k - 1) + len.get(k + 1));
            }
        }

        return ans;
    }
}