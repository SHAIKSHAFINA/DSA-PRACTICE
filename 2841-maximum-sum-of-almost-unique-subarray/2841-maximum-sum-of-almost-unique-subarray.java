class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n=nums.size();
        HashMap<Integer,Integer> mp=new HashMap<>();

        int l=0,r=0;
        long sum=0,max=0;

        while(r<n){
            sum+=nums.get(r);
            mp.put(nums.get(r),mp.getOrDefault(nums.get(r),0)+1);

            while((r-l+1)>k){
                sum-=nums.get(l);
                int freq = mp.get(nums.get(l)) - 1;
                
                if (freq == 0)
                    mp.remove(nums.get(l));
                else
                    mp.put(nums.get(l), freq);
                l++;
            }

            if((r-l+1)==k && mp.size()>=m){
                max=Math.max(max,sum);
            }
            r++;
        }

        return max;
    }
}