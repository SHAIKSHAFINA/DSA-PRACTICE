class Solution {
    public int strStr(String s, String t) {
        int n=s.length(),m=t.length();
        int l[]=lps(t);
        int i=0,j=0;

        while(i<n){
            if(j<m && s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else if(j!=0){
                j=l[j-1];
            }
            else{
                i++;
            }
            if(j==m) return i-j;
        }
        return -1;
        
    }

    int[] lps(String s){
        int i=1,len=0,n=s.length();
        int l[]=new int[n];
        
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                l[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=l[len-1];
                    
                }
                else{
                    l[i]=0;
                    i++;
                }
            }
        }
        return l;
    }
}