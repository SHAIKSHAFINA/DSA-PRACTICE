class Solution {
    public int[][] kClosest(int[][] arr, int k) {
        int n=arr.length;
        int[][] a=new int[k][2];
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (A,B)->{
                int distA=A[0] *A[0] +A[1]*A[1];
                int distB=B[0] *B[0] +B[1]*B[1];
                if(distA!=distB){
                    return distB-distA;
                }
                else{
                    return 0;
                }
            }
        );

        for(int i=0;i<n;i++){
            int x=arr[i][0];
            int y=arr[i][1];

            int dist=x*x + y*y;
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            a[i]=pq.poll();
        }
        return a;
    }
}