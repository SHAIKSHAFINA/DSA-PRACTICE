class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        ArrayList<Character> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            sc.add(s[i]);
        }
        
        Collections.reverse(sc);
        for(int i=0;i<n;i++){
            s[i]=sc.get(i);
        }
        return;

       
    }
}