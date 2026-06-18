class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        solve(c,target,start,sum+c[start],sc,res);
        sc.remove(sc.size()-1);

        solve(c,target,start+1,sum,sc,res);

        return;
    }
}