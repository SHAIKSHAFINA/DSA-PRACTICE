class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> sc=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        solve(s,sb,0,res,sc);
        return res;
    }

    void solve(String s,StringBuilder sb,int start,List<List<String>> res,List<String> sc){
        int n=s.length();
        if(start==n){
            res.add(new ArrayList<>(sc));
            return;
        }

        for(int i=start;i<n;i++){
            if(isPalindrome(s,start,i)){
                sc.add(s.substring(start,i+1));
                solve(s,sb,i+1,res,sc);
                sc.remove(sc.size()-1);
            }
        }
    }

    boolean isPalindrome(String sb,int l,int r){
        while(l<=r){
            if(sb.charAt(l)!=sb.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}