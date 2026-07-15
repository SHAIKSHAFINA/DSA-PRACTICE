class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
         int temp=image[sr][sc];
         if(temp==color) return image;

        solve(image,sr,sc,color,n,m,temp);
        return image;
    }

    void solve(int[][]image,int i,int j,int color,int n,int m,int temp){
        if(i<0 || j<0 || i>=n || j>=m) return;
        if(temp==color) return;

        if(image[i][j]!=temp){ return;}
        image[i][j]=color;

        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};

        for(int k=0;k<4;k++){
            solve(image,i+dr[k],j+dc[k],color,n,m,temp);
        }
    }
}