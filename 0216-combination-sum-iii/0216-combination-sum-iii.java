class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sc=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();

        solve(1,l,0,0,n,k,sc);
        return sc;

    }

    void solve(int i,ArrayList<Integer>l,int c,int sum,int n,int k,List<List<Integer>> sc){
        if(sum==n && c==k){
            sc.add(new ArrayList<>(l));
            return;
        }

        if(c==k || sum>n || i>9) return;
        l.add(i);
        solve(i+1,l,c+1,sum+i,n,k,sc);
        l.remove(l.size()-1);
        solve(i+1,l,c,sum,n,k,sc);
        return;
    }
}