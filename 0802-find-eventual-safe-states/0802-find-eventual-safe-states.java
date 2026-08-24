class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> sc=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int V=graph.length;
        
        boolean vis[]=new boolean[V];
        boolean path[]=new boolean[V];
        int check[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,graph,vis,path,check);
            }
        }

        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        
        return ans;
    }

    boolean dfs(int node,int[][] graph,boolean vis[],boolean path[],int check[]){
        
        vis[node]=true;
        path[node]=true;
        check[node]=0;
        for(int x:graph[node]){
            if(!vis[x]){
                
                if(dfs(x,graph,vis,path,check)==true){
                    check[node]=0;
                    return true;
                }
                
            }
            else if(path[x]){
                check[node]=0;
                return true;
            }
        }
        check[node]=1;
        path[node]=false;
        
        return false;
        
    }
}