class Solution {
    public int monotoneIncreasingDigits(int n) {
        char arr[]=Integer.toString(n).toCharArray();
        int x=arr.length;

        for(int i=1;i<arr.length;i++){
            if(arr[i-1] > arr[i]){
                x=i;
                arr[x-1]--;
                while(x>1 && arr[x-2]>arr[x-1]){
                    x--;
                    arr[x-1]--;
                }
                 break;
            }    
        }

         for(int j=x;j<arr.length;j++){
                arr[j]='9';
            }
        return Integer.parseInt(new String(arr));
    }
}