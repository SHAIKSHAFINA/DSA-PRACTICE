class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sc = new ArrayList<>();
        List<String> l = new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        solve(sb,l,sc,0);
        return sc;
    }

    void solve(StringBuilder sb,List<String> l,List<List<String>> sc , int start){
        if(start==sb.length()){
            sc.add(new ArrayList<>(l));
            return;
        }
        StringBuilder t=new StringBuilder();
        for(int i=start;i<sb.length();i++){
            t.append(sb.charAt(i));
            if(isPalindrome(t)){
                l.add(t.toString());
                solve(sb,l,sc,i+1);
                l.remove(l.size()-1);
            }
        }
    }

    boolean isPalindrome(StringBuilder sb){
        int l=0,r=sb.length()-1;

        while(l<r){
            if(sb.charAt(l)!=sb.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
        
    }
}