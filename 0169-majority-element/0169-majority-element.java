class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int num:nums){
           mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }

        return 0;
    }
}