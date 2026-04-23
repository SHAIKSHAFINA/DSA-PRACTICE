class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> sc=new ArrayList<>();
        solve(sc,num,target,0,new StringBuilder(),0,0);
        return sc;
    }

    void solve(List<String> sc,String nums,int target,long ans,StringBuilder res,int start,long last){
        if(start==nums.length() &&ans==target){
            sc.add(res.toString());
            return;
        }

        for(int i=start;i<nums.length();i++){
            if(i>start && nums.charAt(start)=='0') break; 

            String x=nums.substring(start,i+1);
            long num=Long.parseLong(x);
            if(start==0){
                solve(sc, nums, target, num, new StringBuilder().append(x), i+1, num);
                continue;
            }
            solve(sc,nums,target,ans-last+(last*num),new StringBuilder(res).append("*").append(x),i+1,last*num);

            solve(sc,nums,target,ans+num,new StringBuilder(res).append("+").append(x),i+1,num);

            solve(sc,nums,target,ans-num,new StringBuilder(res).append("-").append(x),i+1,-num);
        }

        return;
    }
}