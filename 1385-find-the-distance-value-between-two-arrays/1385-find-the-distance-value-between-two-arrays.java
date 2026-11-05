class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        int m=arr2.length;
        int co=0;
        //boolean dis=true;

        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<m;j++){
                if(Math.abs(arr1[i]-arr2[j])>d){
                    //dis=false;
                    c++;
                }
            }
            if(c==m){
                co++;
            }
        }

        return co;
    }
}