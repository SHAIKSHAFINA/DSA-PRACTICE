class Solution {
    class Pair{
        int i;
        int j;
        int k;

        Pair(int a,int b,int c){
            i=a;
            j=b;
            k=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int a[][]= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(a[i],Integer.MAX_VALUE);
        }
        a[0][0]=0;
        
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};

        PriorityQueue<Pair> pq=new PriorityQueue<>((c,b)->c.k-b.k);
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.i;
            int y=p.j;
            int z=p.k;

            if(z!=a[x][y]) continue;

            if(x==n-1 && y==m-1) return z;

            for(int k=0;k<4;k++){
                int r=dr[k]+x;
                int c=dc[k]+y;

                if(r>=0 && c>=0 && r<n && c<m){
                    int dist=Math.max(Math.abs(heights[r][c]-heights[x][y]),z);
                    if(dist < a[r][c]){
                        a[r][c]=dist;
                        pq.add(new Pair(r,c,dist));
                    }

                }
            }
        }

        return 0;
    }
}