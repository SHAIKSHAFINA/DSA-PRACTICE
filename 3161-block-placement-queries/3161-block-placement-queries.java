import java.util.*;

class Solution {

    class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int ql, int qr) {
            if (ql > qr) return 0;
            return query(1, 0, n - 1, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {

            if (ql <= l && r <= qr)
                return tree[node];

            if (r < ql || l > qr)
                return 0;

            int mid = (l + r) >> 1;

            return Math.max(
                    query(node * 2, l, mid, ql, qr),
                    query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50005;

        TreeSet<Integer> obs = new TreeSet<>();
        obs.add(0);

        SegmentTree seg = new SegmentTree(MAX);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                Integer prev = obs.floor(x);
                Integer next = obs.ceiling(x);

                obs.add(x);

                seg.update(x, x - prev);

                if (next != null) {
                    seg.update(next, next - x);
                }

            } else {

                int x = q[1];
                int sz = q[2];

                Integer last = obs.floor(x);

                int best = seg.query(0, x);

                best = Math.max(best, x - last);

                ans.add(best >= sz);
            }
        }

        return ans;
    }
}