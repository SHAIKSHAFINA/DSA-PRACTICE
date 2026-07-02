class Solution {
    public boolean repeatedSubstringPattern(String s) {
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
        
        int x=l[n-1];
        if(x>0 && n%(n-x)==0) return true;
        return false;
    }
}