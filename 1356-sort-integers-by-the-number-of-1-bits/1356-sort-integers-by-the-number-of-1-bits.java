class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] a=new Integer[n];

        for(int i=0;i<n;i++){
            a[i]=arr[i];
        }

        Arrays.sort(a,(c,d)->{
            int c1=Integer.bitCount(c);
            int c2=Integer.bitCount(d);
            if(c1!=c2) return c1-c2;
            return c-d;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        
       return arr;
        
    }
    
}