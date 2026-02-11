class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int [] lastSeen={-1,-1,-1};
        int c=0;

        for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                c+=1+Math.min(lastSeen[2],Math.min(lastSeen[0],lastSeen[1]));
            }
        }
        return c;
    }
}