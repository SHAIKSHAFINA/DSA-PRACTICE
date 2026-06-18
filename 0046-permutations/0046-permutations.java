class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> sc=new ArrayList<>();

        boolean used[]=new boolean[n];
        solve(nums,0,sc,l,used);
        return l;
    }

    void solve(int nums[],int start, List<Integer> sc,List<List<Integer>> res,boolean used[]){
        int n=nums.length;
        if(sc.size()==n){
            res.add(new ArrayList<>(sc));
            return;
        }

        for(int i=0;i<n;i++){
            if(used[i]) continue;
            used[i]=true;
            sc.add(nums[i]);
            solve(nums,i+1,sc,res,used);
            sc.remove(sc.size()-1);
            used[i]=false;
        }
        return;
    }
}