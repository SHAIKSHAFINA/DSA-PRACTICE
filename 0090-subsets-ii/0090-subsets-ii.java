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
        
        res.add(new ArrayList<>(sc));
        
        for(int i=start;i<n;i++){
            if(i> start && nums[i]==nums[i-1]) continue;
            sc.add(nums[i]);
            solve(nums,i+1,res,sc);
            sc.remove(sc.size()-1);
        }

       // solve(nums,start+1,res,sc);

        return;
    }
}