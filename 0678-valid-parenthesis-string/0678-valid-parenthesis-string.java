class Solution {
    public boolean checkValidString(String s) {
        int min=0;
        int max=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            
            if(c=='('){
                min++;
                max++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
               min=min-1;
               max=max+1;
            }
            min=Math.max(0,min);
            if(max <0) return false;
        }

        return min==0;
    }
}