class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;
        transpose(arr);
        
        for(int i=0;i<n;i++){
            reverse(arr[i]);
        }
    }

        void transpose(int[][] arr){
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;

                }
            }
        }

        void reverse(int[] row){
            int n=row.length;
            int l=0,r=n-1;
            while(l<r){
                int temp=row[l];
                row[l]=row[r];
                row[r]=temp;

                l++;
                r--;

            }
        }
}