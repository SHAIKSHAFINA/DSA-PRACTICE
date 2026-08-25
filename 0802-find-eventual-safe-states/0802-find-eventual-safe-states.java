class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> sc=new ArrayList<>();
        int V=graph.length;

        for(int i=0;i<V;i++){
            sc.add(new ArrayList<>());
        }

        for(int u=0;u<V;u++){
            for(int v:graph[u]){
                sc.get(v).add(u);
            }   
        }


        int [] indegree=new int[V];
        for(int i=0;i<V;i++){
            indegree[i]=graph[i].length;
        }
       
       
       Queue<Integer> q=new LinkedList<>();
       ArrayList<Integer> a=new ArrayList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
                a.add(i);
            }
        }

        bfs(q,sc,indegree,a);
        Collections.sort(a);
        return a;
    }


    void bfs(Queue<Integer> q,
        ArrayList<ArrayList<Integer>> sc,int indegree[],ArrayList<Integer> a){

        while(!q.isEmpty()){
            int x=q.poll();
            for(int it:sc.get(x)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                    a.add(it);
                }
            }
        }
        return;
    }
}