class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int s=0,max=Integer.MIN_VALUE;
        for(int x:weights){
            if(x>max) max=x;
            s+=x;
        }

        int l=max,r=s,ans=max;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(weights,days,mid)==true){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean possible(int[] weights,int days,int t){
        int n=weights.length;
         int c=0;
         int sum=0;
        for(int i=0;i<n;i++){
            if(sum+weights[i]>t){
                c++;
                sum=0;
                
            }
            sum+=weights[i];
        }
        c++;
        if(c<=days) return true;
        return false;
    }

}