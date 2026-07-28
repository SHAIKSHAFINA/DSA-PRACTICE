class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int pre=0 , c=0;
        mp.put(0,1);

        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(mp.containsKey(pre-k)){
                c+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }

        return c;
    }
}