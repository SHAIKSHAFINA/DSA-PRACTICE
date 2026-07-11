class Solution {
    ArrayList<Integer>[] graph;
    int nodes, degreeSum;
    boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodes = 0;
                degreeSum = 0;
                dfs(i);

                int edgeCount = degreeSum / 2;
                if (edgeCount == nodes * (nodes - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int u) {
        vis[u] = true;
        nodes++;
        degreeSum += graph[u].size();

        for (int v : graph[u]) {
            if (!vis[v])
                dfs(v);
        }
    }
}