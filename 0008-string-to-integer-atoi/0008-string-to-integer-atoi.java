class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int num=0,sign=+1,i=0;

        while(i<n && s.charAt(i)==' '){
            i++;
        }

        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }

        while(i<n && isDigit(i,s)){
            int d=s.charAt(i)-'0';
            if(num > (Integer.MAX_VALUE-d)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            num=num*10+d;
            i++;
        }

        return sign * num;
    }

    boolean isDigit(int i,String s){
        if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            return true;
        }
        return false;
    }
}