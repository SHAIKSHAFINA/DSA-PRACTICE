class Solution {
    class Pair{
        int i;
        int cost;
        int stops;

        Pair(int a,int c,int s){
            i=a;
            cost=c;
            stops=s;

        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int e[]:flights){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new Pair(v,w,0));
        }

        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(src,0,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.i;
            int y=p.cost;
            int z=p.stops;

            for(Pair s:adj.get(x)){
                int f=s.i;
                int g=s.cost;

                if(y+g < dist[f] && z<k+1){
                    dist[f]=y+g;
                    pq.add(new Pair(f,y+g,z+1));
                }
            }

        }


        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

    }
}