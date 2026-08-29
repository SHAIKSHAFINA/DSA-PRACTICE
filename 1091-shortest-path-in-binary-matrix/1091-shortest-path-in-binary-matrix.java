class Solution {
    class Pair{
        int i;
        int j;
        int l;
        Pair(int x,int y,int z){
            i=x;
            j=y;
            l=z;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1 && grid[0][0]==0) return 1;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));

        int dr[]={-1, -1, -1, 0, 1, 1, 1, 0};
        int dc[]={-1, 0, 1, 1, 1, 0, -1, -1};
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int a=p.i;
            int b=p.j;
            int len=p.l;

            for(int k=0;k<8;k++){
                int r=a+dr[k];
                int c=b+dc[k];

                if(r<0 || c<0 || r>=n || c>=n) continue;
                if(grid[r][c]==0){
                    if(r==n-1 && c==n-1) return len+1;
                    grid[r][c]=1;
                    q.add(new Pair(r,c,len+1));

                }

            }
        }

        return -1;

    }
}