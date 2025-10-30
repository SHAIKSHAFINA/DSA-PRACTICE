class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int max=0,best=0;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    c++;
                    if(c>max){
                        max=c;
                        best=i;
                    }
                }
            }
           
        }
        return new int[]{best,max};
    }
}