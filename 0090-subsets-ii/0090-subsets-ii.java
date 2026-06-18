class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> sc=new ArrayList<>();
        int n=nums.length;

        solve(nums,0,res,sc);
        return res;
    }

    void solve(int []nums,int start,List<List<Integer>> res,List<Integer> sc){
        int n=nums.length;
        if(start==n){
            res.add(new ArrayList<>(sc));
            return;
        }
        sc.add(nums[start]);
        solve(nums,start+1,res,sc);
        sc.remove(sc.size()-1);
        
        while(start+1 < n && nums[start]==nums[start+1]) start++;

        solve(nums,start+1,res,sc);

        return;
    }
}