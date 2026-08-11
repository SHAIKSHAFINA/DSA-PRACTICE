class Solution {
    int c=0;
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean [][] vis=new boolean[n][m];
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    c++;
                    dfs(i,j,grid,m,n,vis);
                }
            }
        }
        return c;
    }

    void dfs(int i,int j,char[][] grid,int m,int n,boolean [][] vis){
        
        vis[i][j]=true;

        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];

            if(nr<0 || nr>=n) continue; 
            if(nc<0 || nc>=m) continue;

            if(grid[nr][nc]=='1' && !vis[nr][nc]){
                dfs(nr,nc,grid,m,n,vis);
            }
        }

    }
}