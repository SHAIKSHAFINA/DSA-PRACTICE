class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean zero=false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][j]=Integer.MIN_VALUE +5;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==Integer.MIN_VALUE + 5){
                    int x=i;
                    int y=j;
                    for(int k=0;k<m;k++){
                        if( matrix[x][k]!=Integer.MIN_VALUE +5){
                            matrix[x][k]=0;
                        }
                    }
                    for(int l=0;l<n;l++){
                        if(matrix[l][y]!=Integer.MIN_VALUE +5){
                            matrix[l][y]=0;
                        }
                    }
                }
            }
        }
        

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+5){
                    matrix[i][j]=0;
                }
            }
        }

        
    }
}