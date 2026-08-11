class Solution {
    int c=0;
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;

        for(int i=0;i<n;i++){
            ArrayList<Integer> res=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    res.add(j);
                }
            }
            adj.add(res);
        }
        ArrayList<Integer> sc=new ArrayList<>();
        boolean []vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                solve(i,adj,sc,vis);
            }
        }
        return c;

    }

    void solve(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>sc,boolean [] vis){

        vis[node]=true;
        sc.add(node);

       for(int x:adj.get(node)){
            if(!vis[x]){
                solve(x,adj,sc,vis);
            }
        }
    }
}