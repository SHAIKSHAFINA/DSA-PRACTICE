class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int a[]=new int[n];
        Arrays.fill(a,-1);

        for(int i=0;i<n;i++){
            if(a[i]==-1){
                if(isCheck(i,graph,a)==false){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCheck(int node,int graph[][],int a[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        a[node]=0;

        while(!q.isEmpty()){
            int x=q.poll();

            for(int t:graph[x]){
                if(a[t]==-1){
                    a[t]=1-a[x];
                    q.add(t);
                }
                else if(a[t]==a[x]){
                    return false;
                }
            }
        }

        return true;
    }
}