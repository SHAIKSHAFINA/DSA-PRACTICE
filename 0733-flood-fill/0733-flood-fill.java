class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
         int temp=image[sr][sc];

        solve(image,sr,sc,color,n,m,temp);
        return image;
    }

    void solve(int[][]image,int i,int j,int color,int n,int m,int temp){
        if(i<0 || j<0 || i>=n || j>=m) return;
        int old=temp;
        if(old==color) return;

        if(image[i][j]!=temp){ return;}
        if(image[i][j]==temp){
            image[i][j]=color;
        }
        solve(image,i-1,j,color,n,m,temp);
        solve(image,i,j-1,color,n,m,temp);
        solve(image,i+1,j,color,n,m,temp);
        solve(image,i,j+1,color,n,m,temp);

    }
}