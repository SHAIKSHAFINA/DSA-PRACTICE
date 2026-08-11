class Solution {
    int c=0;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<Integer> sc=new ArrayList<>();
        boolean []vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                solve(i,sc,vis,isConnected,n);
            }
        }
        return c;

    }

    void solve(int node,ArrayList<Integer>sc,boolean [] vis,int[][] isConnected,int n){

        vis[node]=true;
        sc.add(node);

       for(int j=0;j<n;j++){
            if(isConnected[node][j]==1 && !vis[j]){
                solve(j,sc,vis,isConnected,n);
            }
        }
    }
}