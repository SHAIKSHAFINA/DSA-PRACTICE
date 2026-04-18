class Solution {
    public List<List<String>> partition(String sb) {
        List<List<String>> sc = new ArrayList<>();
        List<String> l = new ArrayList<>();
        solve(sb,l,sc,0);
        return sc;
    }

    void solve(String sb,List<String> l,List<List<String>> sc , int start){
        if(start==sb.length()){
            sc.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<sb.length();i++){
            String t=sb.substring(start,i+1);

            if(isPalindrome(sb,start,i)){
                l.add(t);
                solve(sb,l,sc,i+1);
                l.remove(l.size()-1);
            }
        }
    }

    boolean isPalindrome(String sb,int l,int r){

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