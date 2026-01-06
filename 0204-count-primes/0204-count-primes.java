class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0;

        boolean arr[]=new boolean[n+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;

        for(int i=3;i*i<n;i+=2){
            if(arr[i]){
                for(int j=i*i;j<n;j+=i*2){
                    arr[j]=false;
                }
            }
        }

        int count=1;
        for(int i=3;i<n;i+=2){
            if(arr[i]) count++;
        }

        return count;
    }
}