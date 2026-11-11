class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long min=0;
        if(costBoth<cost1+cost2){
            long k1=Math.min(need1,need2);
        
            long ans1=k1*costBoth;
            
            long x=need1-k1;
            long y=need2-k1;
        
            long min1=ans1+cost1*x + cost2*y;
            long k2=Math.max(need1,need2);
            long ans2=k2*costBoth;
            min=Math.min(min1,ans2);
            
        }
        else{
            min=(long)need1*cost1+(long)need2*cost2;
        }
        
        return min;
    }
}