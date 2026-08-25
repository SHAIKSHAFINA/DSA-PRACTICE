class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> mp=new HashSet<>();

        for(int num:nums){
            mp.add(num);
        }

        int multiple=k;
        while(true){
            if(!mp.contains(multiple)) return multiple;
            multiple+=k;
        }
    }
}