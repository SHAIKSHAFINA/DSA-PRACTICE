class Solution {
    class Pair{
        int node;
        int time;

        Pair(int n,int t){
            node=n;
            time=t;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []e:times){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new Pair(v,w));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(k,0));

        int a[]=new int[n+1];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[k]=0;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int idx=p.node;
            int t=p.time;

                for(Pair x:adj.get(idx)){
                    int i=x.node;
                    int j=x.time;

                    if(t+j < a[i]){
                        a[i]=t+j;
                        pq.add(new Pair(i,t+j));
                    }
                }
        }

        int max=Integer.MIN_VALUE;
        
        for(int i=1;i<=n;i++){
            if(a[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,a[i]);
        }

        return max;

    }
}