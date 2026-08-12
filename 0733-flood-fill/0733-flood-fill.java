class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int old=image[sr][sc];

        if(old==color) return image;

        dfs(sr,sc,image,m,n,old,color);

        return image;
    }

    void dfs(int i,int j,int image[][],int m,int n,int old,int color){
        if(i<0 || i>=m || j<0 || j>=n || image[i][j]!=old){
            return;
        }

        image[i][j]=color;


        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];
            dfs(nr,nc,image,m,n,old,color);
        }

    }
}