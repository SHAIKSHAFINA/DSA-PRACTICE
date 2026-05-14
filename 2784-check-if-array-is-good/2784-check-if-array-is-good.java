class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int freq[]=new int[10000];
        Arrays.sort(nums);
        int max=nums[n-1];

        if(n>nums[n-1]+1){
            return false;
        }

        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }

        for(int i=0;i<n;i++){
            if(i!=n-1 && freq[i+1]==0){
                return false;
            }
            if(freq[max]!=2){
                return false;
            }
            if(i!=n-1 && freq[i]>1){
                return false;
            }
        }

        return true;
    }
}