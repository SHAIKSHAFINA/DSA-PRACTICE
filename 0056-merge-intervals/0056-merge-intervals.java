class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length;

       Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];
            }
       }) ;

       int index=0;
       for(int i=1;i<n;i++){
            if(arr[index][1] >=arr[i][0]){
                arr[index][1]=Math.max(arr[index][1] , arr[i][1]);
            }

            else{
                index++;
                arr[index]=arr[i];
            }
       }

       return Arrays.copyOf(arr,index+1);
    }
}