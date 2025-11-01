class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int max=mat[0][0];
        int mi=0,mj=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]>max){
                    max=mat[i][j];
                    mi=i;
                    mj=j;

                }
            }
        }

        return new int[]{mi,mj};
    }
}