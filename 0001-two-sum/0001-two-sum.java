class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            int s=target-nums[i];
            if(mp.containsKey(s)){
                return new int[]{mp.get(s),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}