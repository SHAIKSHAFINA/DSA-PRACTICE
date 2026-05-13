class Solution {
    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
        int l=0,r=1000000000;
        int ans=0;

         Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        while(l<=r){
            int mid=l+(r-l)/2;

            if(isPossible(mid,tasks)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    boolean isPossible(int mid,int tasks[][]){
        for(int a[]:tasks){
            int actual=a[0];
            int minimum=a[1];

            if(minimum > mid){
                return false;
            }
            mid-=actual;
        }

        return true;
    }
}