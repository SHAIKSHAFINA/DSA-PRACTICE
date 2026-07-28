class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> mp=new HashSet<>();

        for(int x:nums){
            mp.add(x);
        }
        int max=0;
        for(int y:mp){
            if(!mp.contains(y-1)){
                int start=y;
                int c=1;

                while(mp.contains(start+1)){
                    start++;
                    c++;
                }

                max=Math.max(max,c);
            }
        }
        return max;
    }
}