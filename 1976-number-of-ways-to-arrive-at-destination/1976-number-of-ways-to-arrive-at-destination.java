class Solution {
    class Pair{
        int num;
        long time;

        Pair(int n,long t){
            num=n;
            time=t;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int m=roads.length;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int e[]:roads){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.time, b.time));

        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        long ways[]=new long[n];
        ways[0]=1;

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.num;
            long y=p.time;

            if(y > dist[x]) continue;

            for(Pair f:adj.get(x)){
                int r=f.num;
                long s=f.time;

                if(y+s <dist[r]){
                    dist[r]=y+s;
                    ways[r]=ways[x];
                    pq.add(new Pair(r,dist[r]));
                }
                else if(y+s==dist[r]){
                    ways[r] = (ways[r] + ways[x]) % 1000000007;
                }
            }
        }

           
        return (int)ways[n-1];
    }
}