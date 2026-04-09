class Solution {
    public List<String> validStrings(int n) {
        List<String> sc=new ArrayList<>();
        int o=n,z=n , c=n;
        solve(o,z,new StringBuilder(),sc,c);
        return sc;

    }

    void solve(int o,int z,StringBuilder op,List<String> sc,int c){
        if(c==0){
            sc.add(op.toString());
            return;
        }
        op.append('1');
        solve(o-1,z,op,sc,c-1);
        op.deleteCharAt(op.length()-1);

        if(op.length() ==0 || op.charAt(op.length()-1)!='0'){
            op.append('0');
            solve(o,z-1,op,sc,c-1);
            op.deleteCharAt(op.length()-1);
        }

        return;
    }
}