class Solution {
    int c=0;
    class Pair{
        int s;
        int t;
        Pair(int a,int b){
            s=a;
            t=b;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean check=false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    check=true;
                    q.add(new Pair(i,j));
                }
            }
        }
        bfs(grid,0,0,q,n,m);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        if(check==false) return 0;

        return c-1;

        
    }

    void bfs(int [][] grid,int i,int j,Queue<Pair> q,int n,int m){
       
        while(!q.isEmpty()){
            int size=q.size();

            while(size-->0){
                Pair pi=q.poll();
                int x=pi.s;
                int y=pi.t;


                if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==0) return;

                int dr[]={-1,1,0,0};
                int dc[]={0,0,-1,1};

                if(grid[x][y]==2){
                    for(int k=0;k<4;k++){
                        int nr=x+dr[k];
                        int nc=y+dc[k];
                        if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                            grid[nr][nc]=2;
                            q.add(new Pair(nr,nc));
                        }

                    }
                }

            }
            c++;
            
        }
    }
}