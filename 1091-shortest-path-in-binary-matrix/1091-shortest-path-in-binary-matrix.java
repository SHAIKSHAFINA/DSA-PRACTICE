class Solution {
    class Pair{
        int i;
        int j;
        Pair(int x,int y){
            i=x;
            j=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));

        int dr[]={-1, -1, -1, 0, 1, 1, 1, 0};
        int dc[]={-1, 0, 1, 1, 1, 0, -1, -1};
        
        int[][] ar=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(ar[i],Integer.MAX_VALUE);
        }

        ar[0][0]=1;
        

        while(!q.isEmpty()){
            Pair p=q.poll();
            int a=p.i;
            int b=p.j;

            for(int k=0;k<8;k++){
                int r=a+dr[k];
                int c=b+dc[k];

                if(r<0 || c<0 || r>=n || c>=n) continue;
                if(ar[r][c]== Integer.MAX_VALUE && grid[r][c]==0){
                    q.add(new Pair(r,c));
                    ar[r][c]=Math.min(ar[r][c],ar[a][b]+1);
                }
            }
        }

        return ar[n-1][n-1]==Integer.MAX_VALUE?-1:ar[n-1][n-1];

    }
}