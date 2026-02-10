class Solution {
    public int captureForts(int[] arr) {
        int n=arr.length;
        int lastIndex=-1;
        int lastType=0 ,max=0;

        for(int i=0;i<n;i++){
            if(arr[i]==1 || arr[i]==-1){
                if(lastIndex!=-1 && arr[i]!=lastType){
                    max=Math.max(max,i-lastIndex-1);
                }

                lastIndex=i;
                lastType=arr[i];
            }
        }
        return max;
    }
}