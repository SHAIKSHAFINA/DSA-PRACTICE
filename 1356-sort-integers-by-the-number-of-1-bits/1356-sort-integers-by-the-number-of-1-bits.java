class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] a=new Integer[n];

        for(int i=0;i<n;i++){
            a[i]=arr[i];
        }

        Arrays.sort(a,(c,d)->{
            int c1=Count(c);
            int c2=Count(d);
            if(c1!=c2) return c1-c2;
            return c-d;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        
       return arr;
        
    }
    
    int Count(int n){
        int c=0;
        while(n>0){
            if(n%2!=0){
                c++;
            }
            n/=2;
        }
        
        return c;
    }
}