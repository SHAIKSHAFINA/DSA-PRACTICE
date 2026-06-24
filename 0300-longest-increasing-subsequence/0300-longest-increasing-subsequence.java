class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> sc=new ArrayList<>();
        sc.add(nums[0]);
        int c=1;

        for(int i=1;i<n;i++){
            if(nums[i] > sc.get(sc.size()-1)){
                sc.add(nums[i]);
                c++;
            }
            else{
                int idx=lower(sc,nums[i]);
                sc.set(idx,nums[i]);
            }
        }
        return c;
    }

    int lower(ArrayList<Integer> sc,int x){
        int l=0,r=sc.size()-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(sc.get(mid)==x){
                return mid;
            }
            else if(sc.get(mid)>=x){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
         return l;
    }
}