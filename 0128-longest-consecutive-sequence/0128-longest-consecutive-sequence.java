class Solution {
    public int longestConsecutive(int[] arr) {
        int n=arr.length;
        if(n==0) return 0;
        if(n==1) return 1;
        Arrays.sort(arr);
        int c=1,max=1;

        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]-1){
                c++;
            }
            else if(arr[i]==arr[i+1]){
                continue;
                //c++;
            }
            else{
                c=1;
            }
            max=Math.max(max,c);
            
        }

        return max;
    }
}