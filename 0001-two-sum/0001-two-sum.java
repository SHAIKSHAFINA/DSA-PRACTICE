class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            int f=target-nums[i];
            if(mp.containsKey(f)){
                return new int[]{mp.get(f),i};
            }
            mp.put(nums[i],i);
        }

        return new int[]{};
    }
}