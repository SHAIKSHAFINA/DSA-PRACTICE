class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> mp=new HashSet<>();

        for(int num:nums){
           if(mp.contains(num)){
            return num;
           }
           mp.add(num);
        }

        return 0;
    }
}