class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int max=0,c=0;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                c++;
            }
            else{
                c=0;
            }
            max=Math.max(max,c);
        }

        return max;
    }
}