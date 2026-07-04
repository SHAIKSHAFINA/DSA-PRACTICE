class Solution {
    public String countAndSay(int n) {
        String curr="1";

        for(int i=2;i<=n;i++){
            curr=solve(curr);
        }
        
        return curr;
    }

    String solve(String s){
        int i=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();

        while(i<n){
            char ch=s.charAt(i);
            int c=0;

            while(i<n && ch==s.charAt(i)){
                c++;
                i++;
            }
            sb.append(c).append(ch);
        }
        return sb.toString();
    }
}