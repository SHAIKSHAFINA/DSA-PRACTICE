class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String prev=countAndSay(n-1);
        return solve(prev);
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