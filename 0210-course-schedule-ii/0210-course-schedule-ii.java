class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> sc=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            sc.add(new ArrayList<>());
        }
        
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            
            sc.get(u).add(v);
        }
        
        int [] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int x:sc.get(i)){
                indegree[x]++;
            }
        }
        
        
       ArrayList<Integer> ans=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i); 
                ans.add(i);
            }
        }

        bfs(q,sc,indegree,ans);
        
        int a[]=new int[ans.size()];
        int k=0;

       for(int i=ans.size()-1;i>=0;i--){
            a[k]=ans.get(i);
            k++;
       }
        
        if(V==a.length) return a;

        return new int[]{};

    }

    void bfs(Queue<Integer> q,
        ArrayList<ArrayList<Integer>> sc,int indegree[],ArrayList<Integer>ans){

        while(!q.isEmpty()){
            int x=q.poll();
            for(int it:sc.get(x)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                    ans.add(it);
                }
            }
        }
    }
}