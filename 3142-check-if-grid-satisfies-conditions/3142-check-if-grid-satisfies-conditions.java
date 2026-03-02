class Solution {
    public boolean satisfiesConditions(int[][] A) {
        int n=A.length;
        int m=A[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i + 1 < n && A[i][j] != A[i + 1][j] || j + 1 < m && A[i][j] == A[i][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }
}