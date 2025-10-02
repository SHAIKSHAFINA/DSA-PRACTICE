class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0,r=(m*n)-1;
        int mid=l+(r-l)/2;
        
        while(l<=r){
            int ele=matrix[mid/n][mid%n];
            if(ele==target){
                return true;
            }
            else if(ele<=target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
             mid=l+(r-l)/2;
        }
        return false;
    }
}