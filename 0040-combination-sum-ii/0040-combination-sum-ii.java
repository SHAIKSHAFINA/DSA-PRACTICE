class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> sc=new ArrayList<>();
        int n=candidates.length;

        solve(candidates,target,0,0,sc,res);

        return res;
    }
    void solve(int[]c,int target,int start,int sum,List<Integer>sc,List<List<Integer>> res){
            
            int n=c.length;
            if(sum==target){
                res.add(new ArrayList<>(sc));
                return;
            }
            if(sum>target){
                return;
            }

            if(start>=n) return;

            sc.add(c[start]);
            solve(c,target,start+1,sum+c[start],sc,res);
            sc.remove(sc.size()-1);
            while(start+1 < n && c[start]==c[start+1]) start++;
            solve(c,target,start+1,sum,sc,res);

            return;
        }
}
