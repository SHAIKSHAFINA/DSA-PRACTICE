class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sc=new ArrayList<>();
        int n=nums.length;
        int subset=1<<n;

        for(int i=0;i<=subset-1;i++){
            List<Integer> mp=new ArrayList<>();
            for(int j=0;j<=n-1;j++){
                if((i & (1<<j))!=0){
                    mp.add(nums[j]);
                }
            }
            sc.add(mp);
        }
        return sc;
    }
}