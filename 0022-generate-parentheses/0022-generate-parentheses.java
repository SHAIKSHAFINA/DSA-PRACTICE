class Solution {
    public List<String> generateParenthesis(int n) {
        int open=n,close=n;
        List<String> sc=new ArrayList<>();
        solve(open,close,new StringBuilder(),sc);
        return sc;
    }

    void solve(int open,int close, StringBuilder op,List<String> sc){
        if(open==0 && close==0){
            sc.add(op.toString());
            return;
        }

        if(open!=0){
            op.append('(');
            solve(open-1,close,op,sc);
            op.deleteCharAt(op.length()-1);
        }

        if(close>open){
            op.append(')');
            solve(open,close-1,op,sc);
            op.deleteCharAt(op.length()-1);
        }
        return;
    }
}