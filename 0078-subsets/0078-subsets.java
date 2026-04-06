class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sc=new ArrayList<>();
        
        ArrayList<Integer> op=new ArrayList<>();
        solve(nums,0,op,sc);
    
        return sc;

    }

    void solve(int []ip,int idx ,ArrayList<Integer> op,List<List<Integer>> sc){
        if(idx==ip.length){
            List<Integer> x=new ArrayList<>(op);
            sc.add(x);
            return;
        }

        int curr=ip[idx];
        
        op.add(curr);
        solve(ip,idx+1,op,sc);
        op.remove(op.size()-1);

        while(idx+1 < ip.length && ip[idx]==ip[idx+1]){
            idx++;
        }
        solve(ip,idx+1,op,sc);
        return;
    }
}