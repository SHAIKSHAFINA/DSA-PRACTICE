class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> sc=new ArrayList<>();
        
        ArrayList<Integer> op=new ArrayList<>();
        solve(nums,op,sc);
    
        return sc;

    }

    void solve(int []ip,ArrayList<Integer> op,List<List<Integer>> sc){
        if(ip.length==0){
            List<Integer> x=new ArrayList(op);
            sc.add(x);
            return;
        }

        int i=ip[0];
        int idx=0;

        int a[]=Arrays.copyOfRange(ip,1,ip.length);
        op.add(i);
        solve(a,op,sc);
        op.remove(op.size()-1);

        while(idx < ip.length && ip[idx]==i){
            idx++;
        }
        int y[]=Arrays.copyOfRange(ip,idx,ip.length);
        solve(y,op,sc);
        return;
    }
}