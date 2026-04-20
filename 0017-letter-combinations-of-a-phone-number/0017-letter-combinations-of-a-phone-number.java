class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> sc=new ArrayList<>();

        HashMap<Character,String> mp=new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        StringBuilder sb=new StringBuilder();

        solve(0,sc,digits,mp,sb);

        return sc;

    }

    void solve(int start,List<String> sc,String digits,HashMap<Character,String>mp,StringBuilder sb){

        if(digits.length()==0){
           sc.add("");
        }
       
        if(start==digits.length()){
            sc.add(sb.toString());
            return;
        }

        String x=mp.get(digits.charAt(start));
        for(int i=0;i<x.length();i++){
            char ch=x.charAt(i);
            sb.append(ch);
            solve(start+1,sc,digits,mp,sb);
            sb.deleteCharAt(sb.length()-1);
            
        }
        return ;
    }
}