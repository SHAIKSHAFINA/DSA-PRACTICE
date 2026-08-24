class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> sc=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            sc.add(new ArrayList<>());
        }
        
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            
            sc.get(v).add(u);
        }
        
        int [] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int x:sc.get(i)){
                indegree[x]++;
            }
        }
        
        
      
       Queue<Integer> q=new LinkedList<>();
       int a[]=new int[V];
       int k=0;

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i); 
                a[k++]=i;
            }
        }

        int x=bfs(q,sc,indegree,a,k);
        if(V!=x) return new int[]{};
        return a;

    }

    int bfs(Queue<Integer> q,
        ArrayList<ArrayList<Integer>> sc,int indegree[],int a[],int k){

        while(!q.isEmpty()){
            int x=q.poll();
            for(int it:sc.get(x)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                    a[k++]=it;
                }
            }
        }

        return k;
    }
}