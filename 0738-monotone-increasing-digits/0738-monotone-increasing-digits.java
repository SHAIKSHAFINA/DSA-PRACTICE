class Solution {
    public int monotoneIncreasingDigits(int n) {
        char arr[]=Integer.toString(n).toCharArray();
        int x=arr.length;

        for(int i=arr.length-1;i>0;i--){
            if(arr[i-1] > arr[i]){
                arr[i-1]--;
                x=i;
            }    
        }

         for(int i=x;i<arr.length;i++){
                arr[i]='9';
        }
        return Integer.parseInt(new String(arr));
    }
}