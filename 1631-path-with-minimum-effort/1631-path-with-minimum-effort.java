class Solution {
    class Pair{
        int a;
        int b;

        Pair(int u,int v){
            a=u;
            b=v;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                min=Math.min(min,heights[i][j]);
                max=Math.max(max,heights[i][j]);

            }
        }
        int l=0,r=max-min;

        while(l<r){
            int mid=l+(r-l)/2;
            if(solve(heights,mid,n,m)){
                r=mid;
            }
                
            else{
                l=mid+1;
            }
        }

        return l;
    }

    boolean solve(int[][] heights,int mid,int n,int m){
        Queue<Pair> pq=new LinkedList<>();
        boolean vis[][]=new boolean[n][m];
        vis[0][0]=true;

        pq.add(new Pair(0,0));

        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};


        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.a;
            int y=p.b;

            for(int k=0;k<4;k++){
                int r=dr[k]+x;
                int c=dc[k]+y;

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(!vis[r][c] && (Math.abs(heights[x][y]-heights[r][c]) <= mid)){
                    vis[r][c]=true;
                    pq.add(new Pair(r,c));
                    if(r==n-1 && c==m-1) return true;
                }

            }
        }

            return false;

    }
}