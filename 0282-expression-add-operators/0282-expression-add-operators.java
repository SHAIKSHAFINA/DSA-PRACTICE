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
                int len = res.length();
                res.append(x);
                solve(sc, nums, target, num, res, i+1, num);
                res.setLength(len);
                continue;
            }
            int len=res.length();
            solve(sc,nums,target,ans-last+(last*num),res.append("*").append(x),i+1,last*num);
            res.setLength(len);

            len=res.length();
            solve(sc,nums,target,ans+num,res.append("+").append(x),i+1,num);
            res.setLength(len);

            len=res.length();
            solve(sc,nums,target,ans-num,res.append("-").append(x),i+1,-num);
            res.setLength(len);
        }

        return;
    }
}