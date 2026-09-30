class Solution {
    private int timer=1;
    private void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj, List<List<Integer>> critical, int[] vis, int[] tin, int[] low){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;

        for(Integer it:adj.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,adj,critical,vis,tin,low);
                low[node]=Math.min(low[node],low[it]);

                if(low[it]>tin[node]){
                    critical.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        List<List<Integer>> critical=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> e:connections){
            int u=e.get(0);
            int v=e.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];

        dfs(0,-1,adj,critical,vis,tin,low);
        return critical;

    }
}