class Solution {
    public List<String> generateParenthesis(int n) {
        int open=n,close=n;
        List<String> sc=new ArrayList<>();
        solve(open,close,"",sc);
        return sc;
    }

    void solve(int open,int close, String op,List<String> sc){
        if(open==0 && close==0){
            sc.add(op);
            return;
        }

        if(open!=0){
            String op1=op + '(';
            solve(open-1,close,op1,sc);
        }

        if(close>open){
            String op2=op+')';
            solve(open,close-1,op2,sc);
        }
        return;
    }
}