class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean vis[][]=new boolean[m][n];
        int a[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==sr && j==sc && !vis[i][j]){
                    a[i][j]=color;
                    vis[i][j]=true;
                    dfs(i,j,vis,a,image,sr,sc,m,n);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    a[i][j]=image[i][j];
                }
            }
        }

        return a;
    }

    void dfs(int i,int j,boolean [][] vis,int a[][],int image[][],int sr,int sc,int m,int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }

        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];

            if(nr<0 || nr>=m) continue;
            if(nc<0 || nc>=n) continue;

            if(!vis[nr][nc] && image[nr][nc]==image[sr][sc]){
                a[nr][nc]=a[sr][sc];
                vis[nr][nc]=true;
                dfs(nr,nc,vis,a,image,sr,sc,m,n);
            }
        }

    }
}