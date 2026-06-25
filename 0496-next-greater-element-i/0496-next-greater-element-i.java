class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> nge = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();

        for (int x : nums2) {
            while (!st.isEmpty() && st.peek() < x) {
                nge.put(st.pop(), x);
            }
            st.push(x);
        }

        while (!st.isEmpty()) {
            nge.put(st.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nge.get(nums1[i]); 
        }

        return ans;
    }
}
