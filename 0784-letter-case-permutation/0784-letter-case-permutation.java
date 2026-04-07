class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> sc=new ArrayList<>();
        solve(s,new StringBuilder(),sc);
        return sc;

    }

    void solve(String ip,StringBuilder op, List<String> sc){
        if(ip.length()==0){
            sc.add(op.toString());
            return;
        }

        char ch=ip.charAt(0);
        String rem=ip.substring(1);
        if(Character.isLetter(ch)){
            op.append(Character.toLowerCase(ch));
            solve(rem,op,sc);
            op.deleteCharAt(op.length()-1);
            
            op.append(Character.toUpperCase(ch));
            solve(rem,op,sc);
            op.deleteCharAt(op.length()-1);
        }
        else{
            op.append(ch);
            solve(rem,op,sc);
            op.deleteCharAt(op.length()-1);
        }
        return;


    }
}