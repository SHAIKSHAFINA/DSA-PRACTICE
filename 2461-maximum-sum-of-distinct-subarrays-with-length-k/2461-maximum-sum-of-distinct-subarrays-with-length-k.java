class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        int l=0,r=0;
        long sum=0,max=0;

        while(r<n){
            
            sum+=nums[r];
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while((r-l+1)>k || mp.get(nums[r])>1){
                sum-=nums[l];
                int freq = mp.get(nums[l]) - 1;
                if (freq == 0)
                    mp.remove(nums[l]);
                else
                    mp.put(nums[l], freq);
                l++;
            }

            if((r-l+1)==k){
                max=Math.max(max,sum);
            }
            r++;
        }

        return max;
    }
}