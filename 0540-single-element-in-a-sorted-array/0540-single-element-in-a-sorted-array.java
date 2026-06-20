class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> mp=new HashSet<>();

        for(int num:nums){
            if(mp.contains(num)){
                mp.remove(num);
            }
            else{
                mp.add(num);
            }
        }

        int x=0;
        for(int y:mp){
            x=y;
        }

        return x;
    }
}