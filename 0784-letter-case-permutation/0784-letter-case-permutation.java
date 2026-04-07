class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> sc=new ArrayList<>();
        solve(s,"",sc);
        return sc;

    }

    void solve(String ip,String op, List<String> sc){
        if(ip.length()==0){
            sc.add(op);
            return;
        }

        char ch=ip.charAt(0);
        String rem=ip.substring(1);
        if(Character.isLetter(ch)){
            String op1=op+Character.toLowerCase(ch);
            String op2=op+Character.toUpperCase(ch);

            solve(rem,op1,sc);
            solve(rem,op2,sc);
        }
        else{
            String op1=op+ch;
            solve(rem,op1,sc);
        }
        return;


    }
}