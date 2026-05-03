class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(s.length()!=goal.length()){
            return false;
        }
        for(int i=0;i<n;i++){
            if((s+s).contains(goal)){ // substring of s+s must be goal
                return true;
            }
        }
        return false;
    }
}