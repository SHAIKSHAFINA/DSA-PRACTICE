class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(int x:mp.keySet()){
            if(mp.get(x)>n/2){
                return x;
            }
        }
        return 0;
    }
}