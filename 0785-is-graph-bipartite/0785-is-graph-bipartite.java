class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int a[]=new int[n];
        Arrays.fill(a,-1);

        for(int i=0;i<n;i++){
            if(a[i]==-1){
                a[i]=0;
                if(isCheck(i,graph,a)==false){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCheck(int node,int graph[][],int a[]){

        for(int t:graph[node]){
            if(a[t]==-1){
                a[t]=1-a[node];
                if(isCheck(t,graph,a)==false) return false;
            }
            else if(a[t]==a[node]){
                return false;
            }
        }

        return true;
    }
}