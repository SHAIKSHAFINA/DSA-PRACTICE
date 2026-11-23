class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> sc=new HashSet<>();

        for(int x:nums){
            if(sc.contains(x)){
                return true;
            }
            sc.add(x);
        }

        return false;
    }
}